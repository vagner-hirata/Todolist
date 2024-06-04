import { HttpErrorResponse } from '@angular/common/http';
import { ToDoList } from './todolist';
import { ToDoListService } from './todolist.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  public todoLists: ToDoList[] = [];
  public deleteList: ToDoList | undefined;
  public editList: ToDoList | undefined;

  constructor(
    private toDoListService: ToDoListService,

  ) { }

  // Need this for maintaining the data on screen

  ngOnInit(): void {
    this.getLists();
  }


  // Get all the lists
  public getLists(): void {
    this.toDoListService.showList().subscribe(
      {
        next: (response: ToDoList[]) => {
          this.todoLists = response;
        },
        error: (error: HttpErrorResponse) => {
          alert(error.message);
        }
      }
    );
  }

  public onAddList(addForm: NgForm):
    void {
    document.getElementById
      ('add-list-form')?.click()
    this.toDoListService.createList(addForm.value).subscribe(
      {
        next: (response: ToDoList) => {
          this.getLists();
          addForm.reset();
        },
        error: (error: HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      }
    )
  }

  public onUpdateList(ToDoList: ToDoList): void {
    this.toDoListService.updateList(ToDoList).subscribe(
      {
        next: (response: ToDoList) => {
          this.getLists();
        },
        error: (error: HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }


  public onDeleteList(ToDoListId: number): void {
    this.toDoListService.deleteList(ToDoListId).subscribe(
      {
        next: (response: void) => {
          this.getLists();
        },
        error: (error: HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }
  public onOpenModal(ToDoList: ToDoList | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'edit') {
      this.editList = ToDoList!;
      button.setAttribute('data-bs-target', '#updateListModal');
    }
    if (mode === 'delete') {
      this.deleteList = ToDoList!;
      button.setAttribute('data-bs-target', '#deleteListModal');
    }
    container?.appendChild(button);
    button.click();
  }
}
