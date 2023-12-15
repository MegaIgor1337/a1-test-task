    package a1.test.task.task3.controller;

    import a1.test.task.task3.dto.PostingDto;
    import a1.test.task.task3.entity.Login;
    import a1.test.task.task3.entity.Posting;
    import a1.test.task.task3.service.LoginService;
    import a1.test.task.task3.service.PostingService;
    import a1.test.task.task3.util.CsvReader;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.media.ArraySchema;
    import io.swagger.v3.oas.annotations.media.Content;
    import io.swagger.v3.oas.annotations.media.Schema;
    import io.swagger.v3.oas.annotations.responses.ApiResponse;
    import lombok.RequiredArgsConstructor;
    import org.springframework.format.annotation.DateTimeFormat;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    import java.time.LocalDate;
    import java.util.List;

    import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("api/v1/postings")
    public class PostingRestController {
        private final PostingService postingService;
        private final LoginService loginService;
        @Operation(summary = "Get list of postings by date")
        @ApiResponse(responseCode = "200", description = "GET", content = @Content(mediaType = APPLICATION_JSON_VALUE,
                array = @ArraySchema(schema = @Schema(implementation = PostingDto.class))))
        @GetMapping
        public ResponseEntity<List<PostingDto>> get(
                @RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                @RequestParam(name = "authorized", required = false) Boolean authorized
        ) {
           List<PostingDto> postingsDto = postingService.getPostingsByParams(startDate, endDate, authorized);
           return ResponseEntity.ok(postingsDto);
        }
    }
