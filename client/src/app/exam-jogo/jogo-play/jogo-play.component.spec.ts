import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JogoPlayComponent } from './jogo-play.component';

describe('JogoPlayComponent', () => {
  let component: JogoPlayComponent;
  let fixture: ComponentFixture<JogoPlayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JogoPlayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JogoPlayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
