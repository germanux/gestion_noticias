import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroNoticiaComponent } from './registro-noticia.component';

describe('RegistrNoticiaComponent', () => {
  let component: RegistroNoticiaComponent;
  let fixture: ComponentFixture<RegistroNoticiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistroNoticiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistroNoticiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
