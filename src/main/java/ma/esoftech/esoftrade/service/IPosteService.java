package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.PosteCategoryDTO;
import ma.esoftech.esoftrade.DTO.PosteDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exception.PosteNotFoundException;
import ma.esoftech.esoftrade.model.CategoryPoste;
import ma.esoftech.esoftrade.model.Poste;
import ma.esoftech.esoftrade.model.User;

public interface IPosteService {

	public PosteDTO findPosteById(Long id) throws PosteNotFoundException ;
	public PosteDTO findPosteByRef(String ref) throws PosteNotFoundException  ;
	public List<PosteDTO> getAllPoste(int start, int length,String sorting, String filter);
	public List<PosteDTO>getPosteByCategory(int start, int length, String sorting, PosteCategoryDTO category);
	public long createPoste(PosteDTO poste, UserDTO creator);
	public void updatePoste(PosteDTO poste, UserDTO modifier) throws PosteNotFoundException;
	public long PosteCatCount(String filter);
	public void deletePoste(PosteDTO poste);
	public long PosteCount(String filter);
	public void attachFileToPoste(FileDTO fileDTO,long id,UserDTO modifier) throws PosteNotFoundException;
	public List<PosteDTO> searchPoste(int lenght, int start, String search);
	public List<UserDTO> getListUserByPoste(int lenght, int start,String sorting, String filter, PosteDTO poste);
	public long UserCount(String filter,PosteDTO poste);
}
