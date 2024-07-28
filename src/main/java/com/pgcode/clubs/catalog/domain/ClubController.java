package com.pgcode.clubs.catalog.domain;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Goran Paunovic
 */

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public Iterable<ClubDto> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("{id}")
    public ClubDto getClubById(@PathVariable Integer id) {
        return clubService.getClub(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClubDto createClub(@Valid @RequestBody ClubDto clubDto) {
        return clubService.createClub(clubDto);
    }

    @PutMapping("{id}")
    public ClubDto updateClub(@PathVariable Integer id, @Valid @RequestBody ClubDto clubDto) {
        return clubService.updateClub(id, clubDto);
    }
}
