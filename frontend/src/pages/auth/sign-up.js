import React, { useState } from 'react';
import { Input, Checkbox, Button } from 'antd';
import styled from 'styled-components';
import SiteLayout from '../../components/common/layout';
import {
  EMAIL,
  ESSENTIAL,
  ESSENTIAL_TEXT,
  NICK_NAME,
  PASSWORD,
  PASSWORD_CONFIRM,
  SIGN_UP,
  TERMS_OF_USE,
  TITLE,
  USER_INFO,
  FULL_CONSENT,
} from '../../constants';
import { theme } from '../../style/theme';

const CheckboxGroup = Checkbox.Group;
const plainOptions = [
  '이용약관동의',
  '개인정보처리방침 동의',
  '개인정보 수집 및 이용 동의',
];

const Wrapper = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
`;

const InnerWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 700px;
`;

const Title = styled.p`
  font-family: ${theme.fontNotoSans};
  font-size: ${theme.fontSizeTitle02};
  font-weight: ${theme.weightBold};
`;

const Essential = styled.span`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-end;
`;

const EssentialText = styled.span`
  margin-left: 7px;
  font-size: ${theme.fontSizeBody03};
  color: #cb6c6c;
`;

const Div = styled.div`
  padding: 12.5px;
  padding-top: 21px;
  width: 550px;
`;

const TopLine = styled.div`
  border-top: 1px solid ${theme.colorLine};
`;

const ButtonAntd = styled(Button)`
  width: 500px;
  height: 50px;
  font-size: ${theme.fontSizeTitle02};
  border-radius: 6px;
  margin-top: 10px;
`;

function SignUp() {
  const [checkedList, setCheckedList] = useState('');
  const [checkAll, setCheckAll] = useState(false);

  const onChange = (list) => {
    setCheckedList(list);
    setCheckAll(list.length === plainOptions.length);
  };

  const onCheckAllChange = (e) => {
    setCheckedList(e.target.checked ? plainOptions : []);
    setCheckAll(e.target.checked);
  };

  return (
    <SiteLayout>
      <Wrapper>
        <InnerWrapper>
          <Title>{SIGN_UP}</Title>
          <Div>
            {USER_INFO}
            <TopLine style={{ marginTop: '10px' }} />
            {/* <Divider /> --> antd 라인 있음 */}
            <Essential style={{ fontSize: '12px', paddingTop: '4px' }}>
              *{ESSENTIAL}
            </Essential>
          </Div>
          <Div>
            {EMAIL}
            <EssentialText>{ESSENTIAL_TEXT}</EssentialText>
            <Input
              placeholder="이메일 주소를 입력해주세요."
              style={{ marginTop: '9px' }}
            />
          </Div>
          <Div>
            {NICK_NAME}
            <Input
              placeholder="닉네임을 입력해주세요."
              style={{ marginTop: '9px' }}
            />
          </Div>
          <Div>
            {PASSWORD}
            <Input.Password
              placeholder="비밀번호를 입력해주세요."
              style={{ marginTop: '9px' }}
            />
          </Div>
          <Div>
            {PASSWORD_CONFIRM}
            <Input.Password
              placeholder="비밀번호 확인을 입력해주세요."
              style={{ marginTop: '9px' }}
            />
          </Div>
          <Div style={{ marginTop: '65px' }}>
            {TERMS_OF_USE}
            <TopLine style={{ marginTop: '10px' }} />
          </Div>
          <Div>
            <Checkbox onChange={onCheckAllChange} checked={checkAll}>
              {FULL_CONSENT}
            </Checkbox>
          </Div>
          <Div>
            <CheckboxGroup
              options={plainOptions}
              value={checkedList}
              onChange={onChange}
            />
          </Div>
          <Div>
            <ButtonAntd type="primary">{SIGN_UP}</ButtonAntd>
          </Div>
        </InnerWrapper>
      </Wrapper>
    </SiteLayout>
  );
}

export default SignUp;
