package com.ubaid.jconnect.sessions.dao;

import java.util.List;

import com.ubaid.jconnect.sessions.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<Session, Long>
{
	@Query(value = "select * from session where sender_id = :sender_id or receiver_id = :sender_id order by last_time_active desc",
			nativeQuery = true)
	List<Session> findAllByUserId(@Param("sender_id") Long senderId);
}
