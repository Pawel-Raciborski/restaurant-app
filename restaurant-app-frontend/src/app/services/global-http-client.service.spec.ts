import { TestBed } from '@angular/core/testing';

import { GenericHttpClientService } from './generic-http-client.service';

describe('GlobalHttpClientService', () => {
  let service: GenericHttpClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GenericHttpClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
