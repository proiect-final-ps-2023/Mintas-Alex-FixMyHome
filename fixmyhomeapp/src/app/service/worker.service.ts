import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Worker } from "../interface/worker";

@Injectable({
    providedIn: 'root'
})

export class WorkerService {
    private apiServerUrl = 'http://localhost:8080';

    constructor(private http: HttpClient) { }

    public getWorkers(): Observable<Worker[]> {
        return this.http.get<Worker[]>(`${this.apiServerUrl}/worker/getWorkers`);
    }

    public createWorker(worker: Worker): Observable<Worker> {
        return this.http.post<Worker>(`${this.apiServerUrl}/worker/createWorker`, worker);
    }

    public updateWorker(worker: Worker): Observable<Worker> {
        return this.http.put<Worker>(`${this.apiServerUrl}/worker/updateWorker`, worker);
    }

    public deleteWorker(workerId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/worker/deleteWorker/${workerId}`);
    }
}