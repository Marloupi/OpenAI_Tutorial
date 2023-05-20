package com.example.demo;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
@AllArgsConstructor
public class ImageGeneratorController {

    private static final Logger LOG = LoggerFactory.getLogger(ImageGeneratorController.class);

    private final ImageGeneratorService imageGeneratorService;

    @PostMapping("generate")
    public ResponseEntity<GenerateImageResponse> generateImage(@Valid @RequestBody final GenerateImageRequest request) {
        LOG.info("Received image generation request: {}", request);
        final GenerateImageResponse response = imageGeneratorService.generateImage(request);
        LOG.info("Generated image: {}", response);
        return ResponseEntity.ok(response);
    }

}
