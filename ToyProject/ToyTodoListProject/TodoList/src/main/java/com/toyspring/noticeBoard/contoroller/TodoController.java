package com.toyspring.noticeBoard.contoroller;


import com.toyspring.noticeBoard.Entity.Todo;
import com.toyspring.noticeBoard.dto.TodoPatchDto;
import com.toyspring.noticeBoard.dto.TodoPostDto;
import com.toyspring.noticeBoard.dto.TodoResponseDto;
import com.toyspring.noticeBoard.errorresponse.ErrorResponse;
import com.toyspring.noticeBoard.mapper.TodoMapper;
import com.toyspring.noticeBoard.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/")
@Slf4j
@Validated
@CrossOrigin(origins = "*")
public class TodoController {


    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoMapper mapper;


    @PostMapping
    public ResponseEntity create(@RequestBody @Valid TodoPostDto postDto){

      Todo todo = mapper.todoPostDtoToTodo(postDto);

      Todo createTodo = todoService.newWrite(todo);

      TodoResponseDto responseDto = mapper.todoToTodoResponseDto(createTodo);

      System.out.println("responseDto = " + responseDto);

      System.out.println("Todo 포스팅 완료");
      return new ResponseEntity<>(responseDto, HttpStatus.CREATED);




    }

    @PatchMapping("/{todo_id}")
    public ResponseEntity update(@Positive @PathVariable("todo_id") @Min(1) Long todoId,@Validated @RequestBody TodoPatchDto requestBody){
        requestBody.setTodoId(todoId);

        Todo updateTodo = todoService.patch(mapper.todoPatchDtoToTodo(requestBody));


        System.out.println("Todo 패치 완료");
        return new ResponseEntity<>(mapper.todoToTodoResponseDto(updateTodo),HttpStatus.OK);
    }

    @GetMapping("/{todo_id}")
    public ResponseEntity findTodo(@Positive @PathVariable("todo_id") @Min(1) Long todoId){
        Todo todo = todoService.search(todoId);


        System.out.println("Todo 하나 찾기");
        return new ResponseEntity(todo,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity readAll(){
        List<Todo> findTodo = todoService.searchAll();

        System.out.println("Todo 모두 찾기");
        return new ResponseEntity<>(findTodo,HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{todo_id}")
    public ResponseEntity delete(@PathVariable("todo_id") Long todoId){

       todoService.deleteTodo(todoId);

        System.out.println("Todo 삭제");
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //회원정보처리 오류에 관한 예외에 대한 메서드입니다.
    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException e){

        //잘못된 응답 데이터를 받았을 시 methodArgumentNotValidException 발동
        //ErrorResponse 클래스를 사용해 보다 자세한 오류 사항 확인가능

//        ex)
//        {
//            "fieldError": [
//            {
//                "field": "title",
//                    "rejectedValue": "",
//                    "reason": "타이틀은 공백일 수 없습니다."
//            }
//    ]
//        }


        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        //에러리스폰 클래스 사용하기
        List<ErrorResponse.FieldError> errors =
                fieldErrors.stream()
                        .map(error -> new ErrorResponse.FieldError(
                                error.getField(),
                                error.getRejectedValue(),
                               error.getDefaultMessage()))
                        .collect(Collectors.toList());

        return new ResponseEntity(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }



}
