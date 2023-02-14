package theMuse.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import theMuse.dto.MusicalDto;

public interface MusicalService {
	
	// 뮤지컬 정보 목록 조회 	
	public int MusicalListCount() throws Exception;
	
    // 검색 조건과 일치하는 제품 중 offset부터 8개를 조회하여 반납하는 기능
	public List<MusicalDto> selectMusicalList(int offset) throws Exception;
	
	// 관리자 : 뮤지컬 정보 등록
	// 뮤지컬 정보 이미지 저장
	public void insertMusicalInfo(MusicalDto musicalDto, MultipartFile file) throws Exception;
	String saveFile(MultipartFile file) throws Exception;

	// 관리자 : 뮤지컬 정보 상세 조회
	public MusicalDto selectMusicalDetail(int musicalId) throws Exception;
	
	// 관리자 : 뮤지컬 정보 수정
	public void updateMusicalInfo(MusicalDto musicalDto) throws Exception;
	
	// 관리자 : 뮤지컬 정보 삭제
	public void deleteMusicalInfo(MusicalDto musicalDto) throws Exception;
	
	// 좋아요 수 업데이트 기능
	public void updateLikesCount(int musicalId) throws Exception;
}
