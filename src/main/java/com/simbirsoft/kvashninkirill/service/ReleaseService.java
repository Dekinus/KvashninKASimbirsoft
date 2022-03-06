package com.simbirsoft.kvashninkirill.service;

import com.simbirsoft.kvashninkirill.dto.request.RequestReleaseDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseReleaseDto;

import java.util.List;

public interface ReleaseService {
    ResponseReleaseDto createRelease(RequestReleaseDto requestReleaseDto);

    ResponseReleaseDto editRelease(Long id, RequestReleaseDto requestReleaseDto);

    ResponseReleaseDto getRelease(Long id);

    void deleteRelease(Long id);

    List<ResponseReleaseDto> getAll();
}
