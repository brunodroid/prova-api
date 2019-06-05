import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JogoStartComponent } from './jogo-start.component';

describe('JogoStartComponent', () => {
  let component: JogoStartComponent;
  let fixture: ComponentFixture<JogoStartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JogoStartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JogoStartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
