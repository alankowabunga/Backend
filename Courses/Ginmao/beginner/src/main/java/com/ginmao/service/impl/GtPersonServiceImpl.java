package com.ginmao.service.impl;

import com.ginmao.domain.GtPerson;
import com.ginmao.repository.GtPersonRepository;
import com.ginmao.service.GtPersonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("com.ginmao.service.impl.GtPersonServiceImpl")
public class GtPersonServiceImpl extends BaseEntityServiceImpl<GtPerson, GtPersonRepository> implements GtPersonService {
}
