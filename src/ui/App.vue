<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:addTodo="addTodo"></TodoInput>
    <TodoList v-bind:propsdata="todoItems" @removeTodo="removeTodo"></TodoList>
    <TodoFooter v-on:removeAll="clearAll"></TodoFooter>
  </div>
</template>

<script>
  import TodoHeader from "./components/TodoHeader";
  import TodoInput from "./components/TodoInput";
  import TodoList from "./components/TodoList";
  import TodoFooter from "./components/TodoFooter";
  import TodoDataService from "./service/TodoDataService";

  export default {
    data() {
      return {
        todoItems: []
      }
    },
    created() {
      TodoDataService.retrieveAllTodo().then(response => {
        const data = response.data._embedded.todos;
        for (let i=0; i <data.length; i++) {
          this.todoItems.push(data[i].content);
        }
      })
    },
    methods: {
      addTodo(todoItem) {
        if (!this.todoItems.includes(todoItem)) {
          TodoDataService.addTodoItem({
            todoItem : todoItem
          }).then(response => {
            this.todoItems.push(response.data.content)
          })
        }
      },
      clearAll() {
        TodoDataService.deleteAll().then(()=>{
          this.todoItems = [];
        })
      },
      removeTodo(todoItem, index) {
        TodoDataService.deleteTodo(todoItem).then(() => {
          this.todoItems.splice(index, 1);
        })
      }
    },
    components: {
      'TodoHeader': TodoHeader,
      'TodoInput': TodoInput,
      'TodoList': TodoList,
      'TodoFooter': TodoFooter
    }
  }
</script>

<style>
  body {
    text-align: center;
    background-color: #F6F6F8;
  }
</style>
