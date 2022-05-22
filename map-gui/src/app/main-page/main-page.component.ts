import { GrpcTestRestControllerService } from './../../../api/api/grpcTestRestController.service';
import { CashFlow } from './../../../api/model/cashFlow';
import { IncomeStatement } from './../../../api/model/incomeStatement';
import { BalanceSheet } from './../../../api/model/balanceSheet';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { finalize, forkJoin, Observable, timer } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { ValueCalcModalComponent } from '../value-calc-modal/value-calc-modal.component';

export interface TPData {
  label: string;
  value?: string;
}

export enum STMTS {
  BALANCE,
  INCOME,
  CASH,
}

const stmtsDsMap = new Map<STMTS, MatTableDataSource<any>>([
  [STMTS.BALANCE, new MatTableDataSource<any>([])],
  [STMTS.INCOME, new MatTableDataSource<any>([])],
  [STMTS.CASH, new MatTableDataSource<any>([])],
]);

const stmtsDispColMap = new Map<STMTS, string[]>([
  [STMTS.BALANCE, []],
  [STMTS.INCOME, []],
  [STMTS.CASH, []],
]);

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css'],
})
export class MainPageComponent implements OnInit {
  $stmtsObs: Observable<any>[] = [];
  stmtsDsMapVar = stmtsDsMap;
  stmtsDispColMapVar = stmtsDispColMap;
  stmtEnumVar = STMTS;
  valuations: { name: string; calcres: string }[] = [];

  balanceStmtData: BalanceSheet[] = [];
  incomeStmtData: IncomeStatement[] = [];
  cashfStmtData: CashFlow[] = [];

  balanceSheetVar: BalanceSheet = {};
  incomeSheetVar: IncomeStatement = {};
  cashflowSheetVar: CashFlow = {};

  displayedColBal: string[] = [];
  displayedColInc: string[] = [];
  displayedColCash: string[] = [];

  symbol: string = 'A';
  symbolPeers: string[] = [];

  constructor(
    private stmtService: GrpcTestRestControllerService,
    public dialog: MatDialog
  ) {
    this.$stmtsObs.push(this.stmtService.getBalancesheetUsingGET(this.symbol));
    this.$stmtsObs.push(
      this.stmtService.getIncomeStatementUsingGET(this.symbol)
    );
    this.$stmtsObs.push(
      this.stmtService.getCashflowStatementUsingGET(this.symbol)
    );

    this.setupTables(this.symbol);
  }

  ngOnInit(): void {}

  transposeTables(labels: string[], data: any[], dsKey: STMTS) {
    let transposedData: TPData[] = [];

    for (let column = 0; column < labels.length; column++) {
      transposedData[column] = {
        label: labels[column],
      };
      for (let row = 0; row < data.length; row++) {
        transposedData[column][`column${row}` as keyof TPData] = data[row][
          labels[column]
        ] as string;
      }
    }

    transposedData = this.displayHack(transposedData);
    stmtsDsMap.get(dsKey)!.data = transposedData;
  }

  fillLabelsForTables(data: any[], dsKey: STMTS) {
    let displCols = stmtsDispColMap.get(dsKey);
    displCols = ['label'];
    for (let i = 0; i < data.length; i++) {
      displCols.push('column' + i);
    }
    stmtsDispColMap.set(dsKey, displCols);
  }

  setupTables(symbol: string) {
    this.symbol = symbol;

    forkJoin(this.$stmtsObs)
      .pipe(
        finalize(() => {
          timer(1000).subscribe(() => {
            this.stmtService.getPeersUsingGET(symbol).subscribe((res) => {
              this.symbolPeers = res?.map((el) => '  ' + el);
            });
          });
        })
      )
      .subscribe((results) => {
        this.balanceStmtData = results[0].balancesheet;
        this.incomeStmtData = results[1].income;
        this.cashfStmtData = results[2].cashflow;

        this.balanceSheetVar = this.balanceStmtData[0];
        this.incomeSheetVar = this.incomeStmtData[0];
        this.cashflowSheetVar = this.cashfStmtData[0];

        this.transposeTables(
          Object.keys(this.balanceSheetVar),
          this.balanceStmtData,
          STMTS.BALANCE
        );
        this.fillLabelsForTables(this.balanceStmtData, STMTS.BALANCE);

        this.transposeTables(
          Object.keys(this.incomeSheetVar),
          this.incomeStmtData,
          STMTS.INCOME
        );
        this.fillLabelsForTables(this.balanceStmtData, STMTS.INCOME);

        this.transposeTables(
          Object.keys(this.cashflowSheetVar),
          this.cashfStmtData,
          STMTS.CASH
        );
        this.fillLabelsForTables(this.balanceStmtData, STMTS.CASH);
      });
  }

  displayHack(transposedData: TPData[]): TPData[] {
    var transposedDataFiltered = transposedData
      .filter((el) => {
        return (
          (el as any).column0 != null &&
          (el as any).column0 != undefined &&
          el.label !== 'symbol'
        );
      })
      .map((el) => {
        el.label = this.capitalizeFirstLetter(
          el.label.replace(/([a-z])([A-Z])/g, '$1 $2')
        );
        return el;
      });

    return transposedDataFiltered;
  }

  capitalizeFirstLetter(input: string) {
    return input.charAt(0).toUpperCase() + input.slice(1);
  }

  openDialog() {
    const dialogRef = this.dialog.open(ValueCalcModalComponent, {
      width: '500px',
      disableClose: true,
      hasBackdrop: false,
      data: this,
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed');
    });
  }

  updateValuations(input: { name: string; calcres: string }) {
    this.valuations.push(input);
  }
}
