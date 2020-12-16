import { Component, OnInit } from '@angular/core';
import { WcfServiceService } from '../wcf-service.service'

@Component({
  selector: 'app-wcf',
  templateUrl: './wcf.component.html',
  styleUrls: ['./wcf.component.css']
})

export class WcfComponent implements OnInit {
  features: [];
  constructor(private wcfService: WcfServiceService) {
    console.log('WcfComponent.constructor()' );
   }

  ngOnInit() {
    if(this.wcfService){
      this.features = JSON.parse(this.wcfService.get() );
    }
  }

  onSaveEdit(item){
    let elem = document.querySelector('#editFeature'+item);
    elem.setAttribute('hidden', true);
    let children = elem.children;
    let feature = this.features[item];
    feature.title = children[0].value;
    feature.description = children[1].value;
    feature.client = children[2].value;
    feature.priority = children[3].value;
    feature.targetDate = children[4].value;
    feature.area = children[5].value;
    feature.index = item;
    feature.action = 'update';
    console.log('Save the update. ' + JSON.stringify(feature));
    this.wcfService.save(feature);
  }

  onEdit(item){
    let elem = document.querySelector('#editFeature'+item);
    elem.removeAttribute('hidden');
    console.log(elem);
  }

  onCancel(item){
    let elem = document.querySelector('#editFeature'+item);
    elem.setAttribute('hidden', true);
    console.log(elem);
  }

  onAdd(){
    console.log("WcfComponent.onAdd()");
  }

  onSaveAdd(){
    console.log("WcfComponent.onSave");
  }

  onDelete(item){
    console.log("WcfComponent.onDelete()");
    let feature = document.querySelector("#featureItem"+item);
    if( feature ){
      feature.remove;
    }
  }

  addFeature(){
    let elem = document.querySelector('.wcf-add-feature');
    elem.removeAttribute('hidden');
    console.log('WcfComponent.addFeature()');
  }

  onSaveNew(){
    let elem = document.querySelector('.wcf-add-feature');
    elem.setAttribute('hidden', true);
    let children = elem.querySelectorAll('input');
    let newFeature = {};
    newFeature.title = children[0].value;
    newFeature.description = children[1].value;
    newFeature.client = children[2].value;
    newFeature.priority = children[3].value;
    newFeature.targetDate = children[4].value;
    newFeature.area = children[5].value;
    this.features.push(newFeature);
    // clear the values
    for( var i = 0; i < children.length; i++){
        children[i].value = '';
    }
    console.log('WcfComponent.onSaveNew()');
  }

  onCancelNew(){
    let elem = document.querySelector('.wcf-add-feature');
    elem.setAttribute('hidden', true);
    let children = elem.querySelectorAll('input');
    // clear the values
    for( var i = 0; i < children.length; i++){
        children[i].value = '';
    }
    console.log('WcfComponent.onCancelNew()');
  }

  featureCount(){
    return this.features.length;
  }
}

export interface WcfFeature{
  title: string;
  description: string;
  client: string;
  priority: number;
  targetDate: string;
  area: string;
}
