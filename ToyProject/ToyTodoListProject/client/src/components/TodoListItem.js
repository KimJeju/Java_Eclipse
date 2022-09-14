import { useState } from "react";
import "./TodoListItem.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrashCan } from "@fortawesome/free-solid-svg-icons";
import { faSquareCheck } from "@fortawesome/free-solid-svg-icons";
import { faPencil } from "@fortawesome/free-solid-svg-icons";

const TodoListItem = ({
  todoListItem,
  deleteTodoListItem,
  updateTodoListItem,
  openUpdateModal,
  setCurId,
}) => {
  const { title, contents, todoId } = todoListItem;
  const [todoChecked, setTodoChecked] = useState(false);

  const handleTodoCheck = () => {
    setTodoChecked(!todoChecked);
  };

  const handleTodoDelete = () => {
    deleteTodoListItem(todoId);
  };

  const handleTodoUpdate = () => {
    // updateTodoListItem(todoId);
    openUpdateModal();
    setCurId(todoId);
  };

  let colorNum = "color" + Math.floor(Math.random() * 10);

  // const aaa = document.querySelector(".todo--list--item");
  // if (setTodoChecked === false) {
  //   aaa.style.filter = "grayscale(100%)";
  // }

  return (
    <div className="todo--list--item" id={colorNum}>
      <p>{title}</p>
      <p>{contents}</p>
      <FontAwesomeIcon
        className="pencil icon"
        icon={faPencil}
        onClick={handleTodoUpdate}
      />
      <FontAwesomeIcon
        className="trash icon"
        icon={faTrashCan}
        onClick={handleTodoDelete}
      />
      <FontAwesomeIcon
        className="checkbox icon"
        icon={faSquareCheck}
        onClick={handleTodoCheck}
      />
    </div>
  );
};

export default TodoListItem;
