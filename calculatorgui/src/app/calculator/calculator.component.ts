import {Component, OnInit} from '@angular/core';
import {MyCalculator} from '../mycalculator';
import {CalcDataService} from '../calc-data.service';
@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  constructor(private dataService: CalcDataService) {}
  data = new MyCalculator("1", "", "1");
  secondVarRequired: boolean = false;
  result: string = "";
  ngOnInit() {
  }
  operators = ['-', '+', '*', '/', 'powered by', 'Square root'];
  singleValueOperatos: Array<string> = ['Square root'];
  submitted = false;

  onSubmit() {
    this.submitted = true;
    console.log('values ' + this.data.firstNumber);
    this.dataService.getResult(this.data).subscribe((res: string) => {
      this.result = res;

    });
    console.log("fetched value=" + this.result);
  }
  //method for dropdown change, based of this next field will be populated
  onChange() {
    if (this.singleValueOperatos.indexOf(this.data.operator) < 0) {
      this.secondVarRequired = true;
    } else {
      this.secondVarRequired = false;
    }

    console.log('value changed ' + this.data.operator);
  }

}

