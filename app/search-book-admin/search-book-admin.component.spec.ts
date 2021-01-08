import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBookAdminComponent } from './search-book-admin.component';

describe('SearchBookAdminComponent', () => {
  let component: SearchBookAdminComponent;
  let fixture: ComponentFixture<SearchBookAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchBookAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchBookAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
