import { TestBed, inject } from '@angular/core/testing';

import { UrlhelperService } from './urlhelper.service';

describe('UrlhelperService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UrlhelperService]
    });
  });

  it('should be created', inject([UrlhelperService], (service: UrlhelperService) => {
    expect(service).toBeTruthy();
  }));
});
