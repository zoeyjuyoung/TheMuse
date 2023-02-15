package theMuse.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import theMuse.dto.MusicalDto;
import theMuse.mapper.MusicalMapper;

@Slf4j
@Service
public class MusicalServiceImpl implements MusicalService {
	
	@Autowired
	private MusicalMapper musicalMapper;
	
	// 설정 파일에서 업로드 파일이 저장되는 경로를 가져와서 가지고 있는 변수
	@Value("${application.upload-path}")
	private String uploadPath;
	
	// 뮤지컬 정보 목록 조회 
	@Override
	public int MusicalListCount() throws Exception {
		return musicalMapper.MusicalListCount();
	}

    // 검색 조건과 일치하는 제품 중 offset부터 8개를 조회하여 반납하는 기능
	@Override
	public List<MusicalDto> selectMusicalList() throws Exception {
		return musicalMapper.selectMusicalList();
	}
	
	// 관리자 : 뮤지컬 정보 등록
	@Override
	public int insertMusicalInfo(MusicalDto musicalDto) throws Exception {
		//String savedFilePath = saveFile(file);
		//musicalDto.setMusicalImg(savedFilePath);
		
		return musicalMapper.insertMusicalInfo(musicalDto);
	}
	
	// 관리자 : 뮤지컬 정보 등록
	// 뮤지컬 정보 이미지 저장
	@Override
	public String saveFile(MultipartFile file) throws Exception {
		String savedFilePath = uploadPath + file.getOriginalFilename();

		File uploadFile = new File(savedFilePath);
		file.transferTo(uploadFile);

		return savedFilePath;
	}

	// 관리자 : 뮤지컬 정보 상세 조회
	@Override
	public MusicalDto selectMusicalDetail(int musicalIdx) throws Exception {
		return musicalMapper.selectMusicalDetail(musicalIdx);
	}
	
	// 관리자 : 뮤지컬 정보 수정
	@Override
	public int updateMusicalInfo(MusicalDto musicalDto) throws Exception {
		return musicalMapper.updateMusicalInfo(musicalDto);
	}
	
	// 관리자 : 뮤지컬 정보 삭제
	@Override
	public int deleteMusicalInfo(int musicalIdx) throws Exception {
		return musicalMapper.deleteMusicalInfo(musicalIdx);
	}
	
	// 좋아요 수 업데이트 기능
	@Override
	public void updateLikesCount(int musicalIdx) throws Exception {
		musicalMapper.updateLikesCount(musicalIdx);
	}


	
}
