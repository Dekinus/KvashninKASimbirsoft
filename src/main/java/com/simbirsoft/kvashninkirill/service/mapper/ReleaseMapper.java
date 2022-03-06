package com.simbirsoft.kvashninkirill.service.mapper;

import com.simbirsoft.kvashninkirill.dto.request.RequestReleaseDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseReleaseDto;
import com.simbirsoft.kvashninkirill.entity.Release;
import org.springframework.stereotype.Component;

@Component
public class ReleaseMapper {

    public Release toRelease(RequestReleaseDto requestReleaseDto) {
        Release release = new Release();
        release.setName(requestReleaseDto.getName());
        release.setStartTime(requestReleaseDto.getStartTime());
        release.setEndTime(requestReleaseDto.getEndTime());
        return release;
    }

    public ResponseReleaseDto toReleaseDto(Release release) {
        ResponseReleaseDto responseReleaseDto = new ResponseReleaseDto();
        responseReleaseDto.setId(release.getId());
        responseReleaseDto.setName(release.getName());
        responseReleaseDto.setStartTime(release.getStartTime());
        responseReleaseDto.setEndTime(release.getEndTime());
        return responseReleaseDto;
    }
}
