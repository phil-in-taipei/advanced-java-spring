package platform.codingnomads.co.springweb.gettingdatafromclient.requestparam.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springweb.gettingdatafromclient.requestparam.models.Task;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTask(@RequestParam Long id) {
        return "ID: " + id;
    }

    @GetMapping(value = "/completed-get",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCompleted(@RequestParam Boolean completed) {
        return "Completed: " + completed;
    }

    @GetMapping(value = "/completed",produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getCompletedTask(@RequestParam(required = false, defaultValue = "false") Boolean completed) {
        return Task.builder().name("Task with completed param").completed(completed).build();
    }


    @GetMapping(value = "/param-name-variable-name-different", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTaskWithDifferentParamAndVariableName(@RequestParam(name = "id") Long taskId) {
        return "ID: " + taskId;
    }

    @GetMapping(value = "/request-param-optional", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskWithOptionalRequestPram(@RequestParam(name = "id", required = false) Long taskId) {
        if (taskId != null){
            return Task.builder().id(taskId).name("Task One").build();
        }
        else
            return Task.builder().name("Task One").build();
    }

    @GetMapping(value = "/default-request-param-value", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskWithDefaultRequestParam(@RequestParam(name = "name", required = false, defaultValue = "Task One") String taskName) {
        return Task.builder().name(taskName).build();
    }

    @GetMapping(value = "/request-parameter-with-multiple-values", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTasksWithNamesRequestParam(@RequestParam(name = "names") List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(i -> Task.builder().id((long) i).name(names.get(i)).build())
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/request-ids", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTasksWithIDsRequestParam(@RequestParam(name = "ids") List<Long> ids) {
        return IntStream.range(0, ids.size())
                .mapToObj(i -> Task.builder().id((long) i).id(ids.get(i)).build())
                .collect(Collectors.toList());
    }


}
