import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsuarioModComponent } from './usuario-mod.component';

describe('UsuarioModComponent', () => {
  let component: UsuarioModComponent;
  let fixture: ComponentFixture<UsuarioModComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsuarioModComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsuarioModComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
