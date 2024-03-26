package com.example.templ.controller;

import com.example.templ.dto.request.MessageOptionsRequest;
import com.example.templ.dto.response.TemplateEntityResponse;
import com.example.templ.service.TemplateResponseEntityService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/templates")
public class TemplateResponseEntityController {

    private final TemplateResponseEntityService templateResponseEntityService;

    @PostMapping("/{id}/options")
    @Operation(summary = "Установить новые варианты ответа для шаблона")
    public ResponseEntity<TemplateEntityResponse> setResponseOptions(
            @RequestHeader Long clientId,
            @PathVariable("id") Long templateId,
            @RequestBody @Valid MessageOptionsRequest optionsRequest
    ) {
        return ResponseEntity.status(CREATED).body(templateResponseEntityService.setResponseOptions(clientId, templateId, optionsRequest));
    }
}
