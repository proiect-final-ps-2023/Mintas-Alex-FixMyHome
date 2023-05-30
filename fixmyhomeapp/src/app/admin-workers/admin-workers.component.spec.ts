import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminWorkersComponent } from './admin-workers.component';

describe('AdminWorkersComponent', () => {
  let component: AdminWorkersComponent;
  let fixture: ComponentFixture<AdminWorkersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminWorkersComponent]
    });
    fixture = TestBed.createComponent(AdminWorkersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
