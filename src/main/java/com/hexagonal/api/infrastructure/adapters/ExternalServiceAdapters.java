
package com.hexagonal.api.infrastructure.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexagonal.api.domain.models.AdditionalTasksInfo;
import com.hexagonal.api.domain.ports.out.ExternalServicePort;

public class ExternalServiceAdapters implements ExternalServicePort {

    // https://jsonplaceholder.typicode.com/users
    // https://jsonplaceholder.typicode.com/todos
    private final RestTemplate restTemplate;
    private String urlUsers;
    private String urlTodo;

    public ExternalServiceAdapters() {
        this.restTemplate = new RestTemplate();
        this.urlUsers = "https://jsonplaceholder.typicode.com/users/";
        this.urlTodo = "https://jsonplaceholder.typicode.com/todos/";
    }

    @Override
    public AdditionalTasksInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = urlTodo + taskId;
        ResponseEntity<JsonPlaceHolderTodo> responseTodo = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = responseTodo.getBody();
        if (todo == null)
            return null;

        apiUrl = urlUsers + todo.getIdUser();
        ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = userResponse.getBody();
        if (user == null)
            return null;
        
        return new AdditionalTasksInfo(user.getId(),user.getName(),user.getEmail());
    }

    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long idUser;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getIdUser() {
            return idUser;
        }

        public void setIdUser(Long idUser) {
            this.idUser = idUser;
        }
    }

    private static class JsonPlaceHolderUser {
        private Long id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }
}
