package com.myboot03.myboot04.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myboot03.myboot04.controller.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {
//	id번호를 인수해서 MyData 인스턴스 추출하는 메서드
	public Optional<MyData> findById(Long id);

	public void deleteById(Long id);

	public List<MyData> findByIdIsNotNullOrderByIdDesc();

	public List<MyData> findByAgeGreaterThan(Integer age);

	public List<MyData> findByAgeBetween(Integer age1, Integer age2);

	public List<MyData> findByIdIs(Long id);
}
