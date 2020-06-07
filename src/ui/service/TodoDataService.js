import axios from 'axios'

const TODO_API_URL = "http://localhost:8088";

class TodoDataService {
  addTodoItem(todoItem) {
    return axios.post(`${TODO_API_URL}/todo`, todoItem)
  }

  retrieveAllTodo() {
    return axios.get(`${TODO_API_URL}/todo`);
  }

  deleteTodo(todoItem) {
    return axios.delete(`${TODO_API_URL}/todo/delete/${todoItem}`);
  }

  deleteAll() {
    return axios.delete(`${TODO_API_URL}/todo/delete/all`);
  }

}

export default new TodoDataService();
