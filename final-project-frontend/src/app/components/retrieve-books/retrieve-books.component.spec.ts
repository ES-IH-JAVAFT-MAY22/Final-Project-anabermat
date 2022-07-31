import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RetrieveBooksComponent } from './retrieve-books.component';

describe('RetrieveBooksComponent', () => {
  let component: RetrieveBooksComponent;
  let fixture: ComponentFixture<RetrieveBooksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RetrieveBooksComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RetrieveBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
