import {Injectable, EventEmitter} from "@angular/core";

@Injectable({
  providedIn: "root"
})
export class ModalService {
  modal: boolean = false;

  private _notificationUpload = new EventEmitter<any>();

  constructor() {}

  get notifyUpload(): EventEmitter<any> {
    return this._notificationUpload;
  }

  openModal() {
    this.modal = true;
  }

  closeModal() {
    this.modal = false;
  }
}
