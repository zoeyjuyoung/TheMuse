package theMuse.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import theMuse.dto.MusicalDto;

@Slf4j
@Service
public class MusicalServiceImpl implements MusicalService {
	// 뮤지컬 정보 목록 조회 
	
	// 검색 조건과 일치하는 제품의 개수 조회 기능	
	
    // 검색 조건과 일치하는 제품 중 offset부터 8개를 조회하여 반납하는 기능
	
	// 관리자 : 뮤지컬 정보 등록
	// 뮤지컬 정보 이미지 저장
	

	// 관리자 : 뮤지컬 정보 상세 조회
	
	// 관리자 : 뮤지컬 정보 수정
	
	// 관리자 : 뮤지컬 정보 삭제
	
	
	// 좋아요 수 업데이트 기능
	
	
	@Override
	public int MusicalListCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MusicalDto> selectMusicalList(int offset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMusicalInfo(MusicalDto musicalDto, MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String saveFile(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MusicalDto selectMusicalDetail(int musicalId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMusicalInfo(MusicalDto musicalDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMusicalInfo(MusicalDto musicalDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLikesCount(int musicalId) throws Exception {
		// TODO Auto-generated method stub
		
	}


	
}
