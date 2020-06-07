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

  export default {
    data() {
      return {
        todoItems: []
      }
    },
    created() {
      if (localStorage.length > 0) {
        for (let i=0; i <localStorage.length; i++) {
          this.todoItems.push(localStorage.key(i));
        }
      }
    },
    methods: {
      addTodo(todoItem) {
        if (!this.todoItems.includes(todoItem)) {
          localStorage.setItem(todoItem, todoItem);
          this.todoItems.push(todoItem)
        }
      },
      clearAll() {
        localStorage.clear();
        this.todoItems = [];
      },
      removeTodo(todoItem, index) {
        localStorage.removeItem(todoItem);
        this.todoItems.splice(index, 1);
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
