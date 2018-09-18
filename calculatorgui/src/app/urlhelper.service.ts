import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UrlhelperService {

  constructor() {}
  private url = "http://localhost:8080/calculator/calculate";
  public additionUrl = this.url + "/addition";
  public subtractionUrl = this.url + "/subtraction";
  public multiplicationUrl = this.url + "/multiplication";
  public divisionUrl = this.url + "/division";
  public squarerootUrl = this.url + "/sqrt/"
  public power = this.url + "/pow"
}
