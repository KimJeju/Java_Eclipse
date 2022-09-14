import { useState, useEffect } from "react";
import "./TodoContainer.css";
import TodoList from "./TodoList";
import Modal from "./Modal";

const TodoContainer = () => {
  const [todolist, setTodolist] = useState([]);
  const [modalIsOpened, setModalIsOpened] = useState(false);
  const [modalRole, setModalRole] = useState("CREATE");
  const [curId, setCurId] = useState(-1);

  const openModal = () => {
    if (todolist.length >= 9) {
      window.alert("todo 생성은 최대 9개 까지만 가능합니다");
    } else {
      setModalRole("CREATE");
      setModalIsOpened(true);
    }
  };

  const openUpdateModal = () => {
    setModalRole("UPDATE");
    setModalIsOpened(true);
  };

  const closeModal = () => {
    setModalIsOpened(false);
  };

  useEffect(() => {
    getTodoList();
  }, []);

  const getTodoList = () => {
    return fetch("kimjeju-database-server.csmds0ouj1iw.ap-northeast-2.rds.amazonaws.com:13306/v2/todos")
      .then((res) => res.json())
      .then((todoItem) => {
        setTodolist(todoItem);
      });
  };

  const addNewTodo = ({ title, contents }) => {
    if (todolist.length >= 9) {
      window.alert("todo 생성은 최대 9개 까지만 가능합니다");
    } else {
      const newTodo = {
        title: title,
        contents: contents,
      };

      fetch("kimjeju-database-server.csmds0ouj1iw.ap-northeast-2.rds.amazonaws.com:13306/v2/todos", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newTodo),
      }).then((res) => {
        if (res.status === 201) {
          getTodoList();
        }
      });
    }
  };

  const deleteTodo = (id) => {
    fetch(`kimjeju-database-server.csmds0ouj1iw.ap-northeast-2.rds.amazonaws.com:13306/v2/todos/${id}`, { method: "DELETE" }) //
      .then((res) => {
        if (res.status === 202 || 204) {
          getTodoList();
        }
      });
  };

  const updateTodo = ({ title, contents, curId }) => {
    // id값으로 해당하는 내용 가져와서 modal에 렌더링해줄지,
    // 새로운 modal 만들지,
    // 아니면 아예 다른 방법으로 만들지 건휘형이랑 얘기 필요
    const updatedTodo = {
      title: title,
      contents: contents,
    };
    fetch(`kimjeju-database-server.csmds0ouj1iw.ap-northeast-2.rds.amazonaws.com:13306/v2/todos/${curId}`, {
      method: "PATCH",
      body: JSON.stringify(updatedTodo),
    }).then((res) => {
      // 정규표현식으로 정확하게 바꿀 수 있음 추후 수정할 것
      if (res.status === 200 || 201) {
        getTodoList();
      }
    }); //
  };

  return (
    <>
      <div className="todo--container">
        <h1
          onClick={() => {
            openModal();
          }}
        >
          My Notes +
        </h1>
        <Modal
          modalRole={modalRole}
          modalTitleText={modalRole === "CREATE" ? "TODO 생성" : "TODO 변경"}
          // todolist={todolist}
          addNewTodo={addNewTodo}
          updateTodo={updateTodo}
          closeModal={closeModal}
          modalIsOpened={modalIsOpened}
          curId={curId}
        />
        <TodoList
          todoList={todolist}
          deleteTodoListItem={deleteTodo}
          updateTodoListItem={updateTodo}
          openModal={openModal}
          openUpdateModal={openUpdateModal}
          setCurId={setCurId}
        />
      </div>
    </>
  );
};

export default TodoContainer;
