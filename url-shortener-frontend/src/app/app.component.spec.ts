import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  let fixture: any;
  let app: AppComponent;
  let compiled: HTMLElement;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      declarations: [AppComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(AppComponent);
    app = fixture.componentInstance;
    compiled = fixture.nativeElement as HTMLElement;
  });

  it('should create the app', () => {
    expect(app).toBeTruthy();
  });

  it(`should have as title 'front-url-shortener'`, () => {
    expect(app.title).toEqual('front-url-shortener');
  });

  it('should render title', () => {
    fixture.detectChanges();
    expect(compiled.querySelector('.content span')?.textContent).toContain('front-url-shortener app is running!');
  });
});
