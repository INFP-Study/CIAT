import React from 'react';
import { SIGN_IN, TITLE } from '../../../constants';
import styled from 'styled-components';
import { Header } from 'antd/lib/layout/layout';
import { Link } from 'react-router-dom';
import { MAIN_URL, SIGN_IN_URL } from '../../../constants/urls';
import { MdAccountCircle } from 'react-icons/md';
import { Affix } from 'antd';
import { theme } from '../../../style/theme';

const HeaderAntd = styled(Header)`
  display: flex;
  justify-content: space-between;
  height: 70px;
  padding: 10px 40px;
  align-items: center;
  background-color: ${theme.colorWhite};
  border-bottom: ${theme.borderLine};
`;

const Logo = styled(Link)`
  font-family: ${theme.fontLogo};
  font-size: ${theme.fontSizeLogo};
  color: ${theme.colorPrimary};
  :hover {
    color: ${theme.colorPrimary};
  }
`;

const UserInfo = styled(Link)`
  display: flex;
  align-items: center;
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeBody01};
  color: ${theme.colorText};
  :hover {
    color: ${theme.colorText};
  }
`;

function SiteHeader() {
  return (
    <Affix offsetTop={0}>
      <HeaderAntd>
        <Logo to={MAIN_URL}>{TITLE}</Logo>
        <UserInfo to={SIGN_IN_URL}>
          <MdAccountCircle
            style={{ fontSize: theme.fontSizeIcon, margin: '0px 10px' }}
          />
          {SIGN_IN}
        </UserInfo>
      </HeaderAntd>
    </Affix>
  );
}

export default SiteHeader;
