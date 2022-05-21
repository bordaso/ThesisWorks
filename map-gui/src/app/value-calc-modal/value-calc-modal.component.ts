import { Component, Inject, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-value-calc-modal',
  templateUrl: './value-calc-modal.component.html',
  styleUrls: ['./value-calc-modal.component.css'],
})
export class ValueCalcModalComponent implements OnInit {
  constructor(
    public dialogRef: MatDialogRef<ValueCalcModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  name = new FormControl();
  calcResult = new FormControl();

  ngOnInit(): void {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  onAddClick(): void {
    let calcres: string = eval(this.calcResult.value).toString();
    if (calcres.indexOf('.') != -1) {
      calcres = calcres.substring(0, calcres.indexOf('.') + 4);
    }

    this.data.updateValuations({
      name: this.name.value,
      calcres: calcres,
    });
    this.name.reset();
    this.calcResult.reset();
  }
}
