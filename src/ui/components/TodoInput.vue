<template>
  <div class="inputBox shadow">
    <input type="text" v-model="newTodoItem" placeholder="할일이 무엇입니까" onfocus="this.placeholder = ''" onblur="this.placeholder = '할일이 무엇입니까'"
           v-on:keyup.enter="addTodo" />
    <span class="addContainer" v-on:click="addTodo">
      <i class="addBtn fas fa-plus" aria-hidden="true"/>
    </span>

    <modal v-if="showModal" @close="showModal = false">
      <h3 slot="header">warning</h3>
      <h4 slot="body">할 일을 입력하세요.</h4>
      <span slot="footer" @click="showModal = false">
        <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
      </span>
    </modal>
  </div>
</template>

<script>
    import Modal from './common/Modal'
    export default {
      data() {
        return {
          newTodoItem: '',
          showModal: false
        }
      },
      methods: {
        addTodo() {
          if (this.newTodoItem !== ""){
            const value = this.newTodoItem && this.newTodoItem.trim();
            this.$emit('addTodo', value);
            this.newTodoItem = "";
          } else {
            this.showModal = !this.showModal
          }
        }
      },
      components: {
        Modal: Modal
      }
    }
</script>

<style scoped>
  input:focus {
    outline: none;
  }
  .inputBox {
    background: white;
    height: 50px;
    line-height: 50px;
    border-radius: 5px;
  }
  .inputBox input {
    border-style: none;
    font-size: 0.9rem;
  }
  .addContainer {
    float: right;
    background: linear-gradient(to right, #6478FB, #8763FB);
    display: inline-block;
    width: 3rem;
    border-radius: 0 5px 5px 0;
  }
  .addBtn {
    color: white;
    vertical-align: middle;
  }
</style>
