import { Injectable } from '@angular/core';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import {WcfComponent} from './wcf/wcf.component';
import {WcfFeature} from './wcf/wcf.component';

export interface WcfFeatures{
  features: [WcfFeature];
}

@Injectable({
  providedIn: 'root'
})
export class WcfServiceService {
  features: WcfFeatures;

  constructor(private http: HttpClient) { }

  get(){
  // I had code to get the JSON from the Spring server but it causes a CORS cross border issue
      let json = '[{"title":"I would like the ability to update products.","description":"As a user, I would like to be given the ability to add, remove, and change products.","client":"Client A","priority":1,"targetDate":"01/01/2021","area":"Products"},{"title":"I would like the ability to update departments.","description":"As a user, I would like to be given the ability to add, remove, and change departments.","client":"Client B","priority":3,"targetDate":"03/01/2021","area":"Products"},{"title":"I would like the ability to update departments.","description":"As a user, I would like to be given the ability to add, remove, and change departments.","client":"Client C","priority":3,"targetDate":"03/01/2021","area":"Products"}]';
      return json;
  }

  save(json){
  // This sould pass the update on but causes a CORS cross border issue
    console.log('WcfServiceService.save() => ' + JSON.stringify(json));
  }

  add(json){
    console.log('add item: ' + json);
  }

  delete(index){
  console.log('remove item at ' + index );
    //this.features.remove(index);
  }
}
