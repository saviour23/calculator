import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MyCalculator} from './mycalculator';
import {Operators} from './operators';
import {UrlhelperService} from './urlhelper.service';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CalcDataService {

  constructor(private http: HttpClient, private urlhelper: UrlhelperService) {}
  url: string;

  getResult(calcData: MyCalculator) {
    this.url="";
    this.getUrl(calcData);
    console.log(this.url);

    return this
      .http
      .get(this.url);



  }


  private getUrl(data: MyCalculator): void {
    if (data.operator == "+") {
      this.url = this.urlhelper.additionUrl + "?firstnumber=" + data.firstNumber + "&secondnumber=" + data.secondNumber;
    } else if (data.operator == "-") {
      this.url = this.urlhelper.subtractionUrl + "?firstnumber=" + data.firstNumber + "&secondnumber=" + data.secondNumber;
    } else if (data.operator == "*") {
      this.url = this.urlhelper.multiplicationUrl + "?firstnumber=" + data.firstNumber + "&secondnumber=" + data.secondNumber;
    } else if (data.operator == "/") {
      this.url = this.urlhelper.divisionUrl + "?firstnumber=" + data.firstNumber + "&secondnumber=" + data.secondNumber;
    } else if (data.operator == "Square root") {
      this.url = this.urlhelper.squarerootUrl+ data.firstNumber;
    } else if (data.operator == "powered by") {
      this.url = this.urlhelper.power + "?base=" + data.firstNumber + "&ext=" + data.secondNumber;
    }
  }
}
