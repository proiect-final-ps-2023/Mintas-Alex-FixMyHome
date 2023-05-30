import { Component, OnInit } from '@angular/core';
import { Worker } from '../interface/worker';
import { WorkerService } from '../service/worker.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Renderer2 } from '@angular/core';
import { js2xml } from 'xml-js';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-admin-workers',
  templateUrl: './admin-workers.component.html',
  styleUrls: ['./admin-workers.component.css']
})
export class AdminWorkersComponent implements OnInit {
  public allWorkers: Worker[];
  public workers: Worker[];
  public editWorker: Worker;
  public deleteWorker: Worker;
  public sortedWorkers: Worker[];
  public orderFirstName: number;
  public orderLastName: number;

  constructor(private workerService: WorkerService, private renderer: Renderer2) { }

  ngOnInit(): void {
    this.getWorkers();
    this.orderFirstName = 1;
    this.orderLastName = 1;
  }

  public getWorkers(): void {
    this.workerService.getWorkers().subscribe(
      (response: Worker[]) => {
        this.allWorkers = response;
        this.workers = [...this.allWorkers];
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddWorker(addForm: NgForm): void {
    document.getElementById('add-worker-form').click();
    this.workerService.createWorker(addForm.value).subscribe(
      (response: Worker) => {
        console.log(response);
        this.getWorkers();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateWorker(worker: Worker): void {
    this.workerService.updateWorker(worker).subscribe(
      (response: Worker) => {
        console.log(response);
        this.getWorkers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteWorker(workerId: number): void {
    this.workerService.deleteWorker(workerId).subscribe(
      (response: void) => {
        console.log(response);
        this.getWorkers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchWorkers(key: string): void {
    console.log(key);
    if (!key) {
      this.workers = [...this.allWorkers];
      return;
    }
    const results: Worker[] = [];
    for (const worker of this.allWorkers) {
      if (worker.firstName.toLowerCase().includes(key.toLowerCase())
        || worker.lastName.toLowerCase().includes(key.toLowerCase())
        || worker.job.toLowerCase().includes(key.toLowerCase())
        || worker.email.toLowerCase().includes(key.toLowerCase())
        || worker.phoneNumber.includes(key)) {
        results.push(worker);
      }
    }
    this.workers = results;
  }

  public onOpenModal(worker: Worker, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addWorkerModal');
    }
    if (mode === 'edit') {
      this.editWorker = worker;
      button.setAttribute('data-target', '#updateWorkerModal');
    }
    if (mode === 'delete') {
      this.deleteWorker = worker;
      button.setAttribute('data-target', '#deleteWorkerModal');
    }
    container?.appendChild(button);
    button.click();
  }

  copyToClipboard(value: string) {
    const tempInput = document.createElement('input');
    this.renderer.appendChild(document.body, tempInput);
    tempInput.style.position = 'fixed';
    tempInput.style.opacity = '0';
    tempInput.value = value;
    document.body.appendChild(tempInput);
    tempInput.select();
    document.execCommand('copy');
    document.body.removeChild(tempInput);
    alert('Copied to clipboard: ' + value);
    this.renderer.removeChild(document.body, tempInput);
  }

  exportWorkersAsXML(): void {
    const options = { compact: true, ignoreComment: true, spaces: 4 };
    const xml = js2xml({ workers: this.allWorkers }, options);

    const blob = new Blob([xml], { type: 'application/xml' });
    const url = URL.createObjectURL(blob);

    const link = document.createElement('a');
    link.href = url;
    link.download = 'workers.xml';
    link.click();

    URL.revokeObjectURL(url);
  }

  exportWorkersAsExcel(): void {
    /* Generate worksheet */
    const ws: XLSX.WorkSheet = XLSX.utils.json_to_sheet(this.allWorkers);
  
    /* Generate workbook and add the worksheet */
    const wb: XLSX.WorkBook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Workers');
  
    /* Save to file */
    XLSX.writeFile(wb, 'workers.xlsx');
  }

  sortWorkersByFirstName(): void {
    this.orderFirstName = -this.orderFirstName;
    this.workers.sort((a, b) => {
      if (a.firstName < b.firstName) {
        return this.orderFirstName;
      }
      if (a.firstName > b.firstName) {
        return -this.orderFirstName;
      }
      return 0;
    });
  }

  sortWorkersByLastName(): void {
    this.orderLastName = -this.orderLastName;
    this.workers.sort((a, b) => {
      if (a.lastName < b.lastName) {
        return this.orderLastName;
      }
      if (a.lastName > b.lastName) {
        return -this.orderLastName;
      }
      return 0;
    });
  }

}
