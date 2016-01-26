/*
 * Copyright 2016 EuregJUG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.euregjug.site.events;

import java.io.Serializable;
import java.util.Optional;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Commandobject for new registrations. Needs getters and setters and all to
 * work inside thymeleaf forms.
 *
 * @author Michael J. Simons, 2016-01-03
 */
public class Registration implements Serializable {

    private static final long serialVersionUID = 770264014400800147L;

    @Size(max = 512)
    private String firstName;

    @NotBlank
    @Size(max = 512)
    private String name;

    @NotBlank
    @Email
    @Size(max = 1024)
    private String email;
        
    private String comment;

    /**
     * This is my super simple spam protection for registrations.
     * 
     * @return True if comment field is empty
     */
    @AssertTrue
    public boolean isValid() {
	return Optional.ofNullable(comment).orElse("").trim().isEmpty();
    }
    
    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
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

    public String getComment() {
	return comment;
    }

    public void setComment(String comment) {
	this.comment = comment;
    }
}
