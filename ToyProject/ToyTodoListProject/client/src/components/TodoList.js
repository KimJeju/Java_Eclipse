import React from "react";
import "./TodoList.css";
import TodoListItem from "./TodoListItem";

const TodoList = ({
  todoList,
  deleteTodoListItem,
  updateTodoListItem,
  openModal,
  openUpdateModal,
  setCurId,
}) => {
  return (
    <div className="todo--list">
      {todoList.length === 0 ? (
        <div
          className="no--todo"
          onClick={() => {
            openModal();
          }}
        >
          <p>현재 페이지에 todo가 없습니다. todo를 입력하세요.</p>
        </div>
      ) : (
        todoList.map((todoListItem, idx) => {
          // map을 통해 생성되는 idx를 넣어주고 있지만
          // 백엔드에서 중간 idx를 delete할시 새로 갱신이 안 되는 문제 발생
          // post 할 때 response로 받아오는 id를 받아와서 사용해줄 것
          return (
            <TodoListItem
              key={idx}
              todoListItem={todoListItem}
              deleteTodoListItem={deleteTodoListItem}
              updateTodoListItem={updateTodoListItem}
              openUpdateModal={openUpdateModal}
              setCurId={setCurId}
            />
          );
        })
      )}
    </div>
  );
};

export default TodoList;
