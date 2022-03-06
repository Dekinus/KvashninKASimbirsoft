package com.simbirsoft.kvashninkirill.service.impl;

import com.simbirsoft.kvashninkirill.dto.request.RequestReleaseDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseReleaseDto;
import com.simbirsoft.kvashninkirill.entity.Release;
import com.simbirsoft.kvashninkirill.exception.ReleaseNotFoundException;
import com.simbirsoft.kvashninkirill.repository.ReleaseRepository;
import com.simbirsoft.kvashninkirill.service.ReleaseService;
import com.simbirsoft.kvashninkirill.service.mapper.ReleaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    private final ReleaseRepository releaseRepository;
    private final ReleaseMapper releaseMapper;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository, ReleaseMapper releaseMapper) {
        this.releaseRepository = releaseRepository;
        this.releaseMapper = releaseMapper;
    }

    @Override
    public ResponseReleaseDto createRelease(RequestReleaseDto requestReleaseDto) {
        Release release = releaseMapper.toRelease(requestReleaseDto);
        releaseRepository.save(release);
        return releaseMapper.toReleaseDto(release);
    }

    @Override
    public ResponseReleaseDto editRelease(Long id, RequestReleaseDto requestReleaseDto) {
        releaseRepository.findById(id).orElseThrow(() -> new ReleaseNotFoundException(id));
        Release release = releaseMapper.toRelease(requestReleaseDto);
        release.setId(id);
        releaseRepository.save(release);
        return releaseMapper.toReleaseDto(release);
    }

    @Override
    public ResponseReleaseDto getRelease(Long id) {
        Release release = releaseRepository.findById(id).orElseThrow(() -> new ReleaseNotFoundException(id));
        return releaseMapper.toReleaseDto(release);
    }

    @Override
    public void deleteRelease(Long id) {
        releaseRepository.findById(id).orElseThrow(() -> new ReleaseNotFoundException(id));
        releaseRepository.deleteById(id);
    }

    @Override
    public List<ResponseReleaseDto> getAll() {
        return releaseRepository.findAll().stream()
                .map(releaseMapper::toReleaseDto).collect(Collectors.toList());
    }
}
