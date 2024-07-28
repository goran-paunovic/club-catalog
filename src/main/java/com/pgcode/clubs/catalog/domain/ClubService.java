package com.pgcode.clubs.catalog.domain;

import org.springframework.stereotype.Service;

/**
 * @author Goran Paunovic
 */

@Service
public class ClubService {
    private final ClubMapper clubMapper;
    private final ClubRepository clubRepository;

    public ClubService(ClubMapper clubMapper, ClubRepository clubRepository) {
        this.clubMapper = clubMapper;
        this.clubRepository = clubRepository;
    }

    public Iterable<ClubDto> getAllClubs() {
        return clubMapper.toDto(clubRepository.findAll());
    }

    public ClubDto getClub(Integer id) {
        Club club = clubRepository.findById(id).orElseThrow(() -> new ClubNotFoundException(id));
        return clubMapper.toDto(club);
    }

    public ClubDto createClub(ClubDto clubDto) {
        return clubMapper.toDto(clubRepository.save(clubMapper.toEntity(clubDto)));
    }

    public ClubDto updateClub(Integer id, ClubDto clubDto) {
        // Fetch club from database
        Club club = clubRepository.findById(id).orElseThrow(() -> new ClubNotFoundException(id));

        // Save changes
        return clubMapper.toDto(clubRepository.save(clubMapper.partialUpdate(clubDto, club)));
    }
}
