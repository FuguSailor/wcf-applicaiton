import { TestBed } from '@angular/core/testing';

import { WcfServiceService } from './wcf-service.service';

describe('WcfServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WcfServiceService = TestBed.get(WcfServiceService);
    expect(service).toBeTruthy();
  });
});
