import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http'
import { ToDoList } from "./todolist";

@Injectable({
  providedIn: 'root'
})
export class ToDoListService {
  private apiServerUrl = 'http://localhost:8080/todolist';

  constructor(private http: HttpClient) { }

  public showList(): Observable<ToDoList[]> {
    return this.http.get<ToDoList[]>(`${this.apiServerUrl}/all`)
  }
  public createList(todolist: ToDoList): Observable<ToDoList> {
    return this.http.post<ToDoList>(`${this.apiServerUrl}/add`, todolist)
  }
  public updateList(todolist: ToDoList): Observable<ToDoList> {
    return this.http.put<ToDoList>(`${this.apiServerUrl}/update`, todolist)
  }
  public deleteList(todolistId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/delete/${todolistId}`)
  }
  public isCompleted(todolist: ToDoList): Observable<ToDoList> {
    return this.http.put<ToDoList>(`${this.apiServerUrl}/completed`, todolist)
  }
}
