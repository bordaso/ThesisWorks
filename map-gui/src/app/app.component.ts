import { Component, ElementRef, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { GrpcTestRestControllerService } from 'api';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';
import { startWith, map, timer } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { MainPageComponent } from './main-page/main-page.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  content!: ElementRef;
  myControl = new FormControl();
  options: string[] = [];
  filteredOptions: Observable<string[]> = {} as Observable<string[]>;
  childMaincomponent: MainPageComponent = {} as MainPageComponent;

  symbol: string = 'A';

  constructor(
    private stmtService: GrpcTestRestControllerService,
    private elRef: ElementRef
  ) {
    this.content = elRef;
    timer(1000).subscribe(() =>
      this.stmtService.getSymbolsUsingGET().subscribe((ressym) => {
        this.options = ressym;
      })
    );
  }

  ngOnInit(): void {
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map((value) => this._filter(value))
    );
  }

  onEnter($event: any) {
    $event.preventDefault();
    this.symbol = $event.target.value;
    this.childMaincomponent.setupTables(this.symbol);
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter((option) =>
      option.toLowerCase().includes(filterValue)
    );
  }

  onChildMainLoaded(component: MainPageComponent | any) {
    if (component instanceof MainPageComponent) {
      this.childMaincomponent = component;
    }
  }

  savePdf() {
    var divHeight = 750; //this.content.nativeElement.offsetHeight;
    var divWidth = 1920; //this.content.nativeElement.offsetWidth;
    var ratio = divHeight / divWidth;
    html2canvas(this.content.nativeElement).then((canvas) => {
      var image = canvas.toDataURL('image/jpeg');
      var doc = new jsPDF('l', 'mm', 'a5');
      var width = doc.internal.pageSize.getWidth();
      var height = doc.internal.pageSize.getHeight();
      //  height = ratio * width;
      doc.addImage(image, 'JPEG', 0, 0, width, height);
      doc.save('map-report-EC33NW.pdf');
    });
  }

  openDialog() {
    this.childMaincomponent.openDialog();
  }
}
