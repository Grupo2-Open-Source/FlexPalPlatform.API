package com.gymfinity.flexpal.platform.testimonials.interfaces.rest;

import com.gymfinity.flexpal.platform.testimonials.domain.model.queries.GetAllTestimonialsQuery;
import com.gymfinity.flexpal.platform.testimonials.domain.model.queries.GetTestimonialByIdQuery;
import com.gymfinity.flexpal.platform.testimonials.domain.services.commandservices.TestimonialCommandService;
import com.gymfinity.flexpal.platform.testimonials.domain.services.queryservices.TestimonialQueryService;
import com.gymfinity.flexpal.platform.testimonials.interfaces.rest.resources.CreateTestimonialResource;
import com.gymfinity.flexpal.platform.testimonials.interfaces.rest.resources.TestimonialResource;
import com.gymfinity.flexpal.platform.testimonials.interfaces.rest.transform.CreateTestimonialCommandFromResourceAssembler;
import com.gymfinity.flexpal.platform.testimonials.interfaces.rest.transform.TestimonialResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/testimonials")
@Tag(name = "Testimonials", description = "Testimonial Management Endpoints")
public class TestimonialController {
    private final TestimonialCommandService testimonialCommandService;
    private final TestimonialQueryService testimonialQueryService;

    public TestimonialController(TestimonialCommandService testimonialCommandService, TestimonialQueryService testimonialQueryService) {
        this.testimonialCommandService = testimonialCommandService;
        this.testimonialQueryService = testimonialQueryService;
    }

    @PostMapping
    public ResponseEntity<TestimonialResource> createTestimonial (@RequestBody CreateTestimonialResource resource) {
        var createTestimonialCommand = CreateTestimonialCommandFromResourceAssembler.toCommandFromResource(resource);
        var testimonialId = testimonialCommandService.handle(createTestimonialCommand);
        if (testimonialId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var getTestimonialByIdQuery = new GetTestimonialByIdQuery(testimonialId.get().getId());
        var testimonial = testimonialQueryService.handle(getTestimonialByIdQuery);
        if (testimonial.isPresent()) {
            var testimonialResource = TestimonialResourceFromEntityAssembler.toResourceFromEntity(testimonial.get());
            return ResponseEntity.ok(testimonialResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{testimonialId}")
    public ResponseEntity<TestimonialResource> getTestimonialById(@PathVariable Long testimonialId) {
        var getTestimonialByIdQuery = new GetTestimonialByIdQuery(testimonialId);
        var testimonial = testimonialQueryService.handle(getTestimonialByIdQuery);
        if (testimonial.isPresent()) {
            var testimonialResource = TestimonialResourceFromEntityAssembler.toResourceFromEntity(testimonial.get());
            return ResponseEntity.ok(testimonialResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TestimonialResource>> getAllTestimonials() {
        var getAllTestimonialsQuery = new GetAllTestimonialsQuery();
        var testimonials = testimonialQueryService.handle(getAllTestimonialsQuery);
        var testimonialResources = testimonials.stream().map(TestimonialResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(testimonialResources);
    }
}
