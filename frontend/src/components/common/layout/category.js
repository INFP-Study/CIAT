import Sider from 'antd/lib/layout/Sider';
import { Affix, Menu } from 'antd';
import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { theme } from '../../../style/theme';
import { Link } from 'react-router-dom';
import { FcShop } from 'react-icons/fc';
import { useDispatch, useSelector } from 'react-redux';
import { getCategoryList } from '../../../store/menu';

const SiderAntd = styled(Sider)`
  width: 200px;
  height: 100vh;
  background-color: ${theme.colorCategory};
  padding: 30px 0px;
  border-right: ${theme.borderLine};
  border-left: ${theme.borderLine};
`;

const MenuAntd = styled(Menu)`
  background-color: ${theme.colorCategory};
  .ant-menu-item-selected,
  .ant-menu-item-active,
  .ant-menu-item::after {
    border-right: 0px;
    color: ${theme.colorText};
  }
`;

const CategoryTitle = styled.p`
  font-family: ${theme.fontBasic};
  font-size: ${theme.fontSizeTitle02};
  font-weight: ${theme.weightSemiBold};
  padding: 0px 15px;
  height: 40px;
  margin-top: 5.5px;
`;

function Category({ location }) {
  const dispatch = useDispatch();

  const [collapsed, setCollapsed] = useState(false);
  const [categoryTitle, setCategoryTitle] = useState();
  const [categoryList, setCategoryList] = useState([]);
  const [isCategory, setIsCategory] = useState(false);

  //카테고리 리스트 가져오기
  const _categoryList = useSelector((state) => state.menu.categoryList);

  //useSelector로 가져온 카테고리 리스트 state에 담기
  useEffect(() => {
    setCategoryList(_categoryList);
  }, [_categoryList]);

  //카테고리 리스트 비어있으면 카테고리 컴포넌트 렌더링 안하게 하는 로직
  useEffect(() => {
    categoryList.length === 0 ? setIsCategory(false) : setIsCategory(true);
  }, [categoryList]);

  //현재 pathname의 카테고리 가져오기
  useEffect(() => {
    dispatch({ type: getCategoryList.type, payload: location.pathname });
  }, [location.pathname]);

  //현재 메뉴 이름 가져오기 => 백엔드에서 현재 메뉴 이름 포함해서 return해달라고 요청 필요
  useEffect(() => {
    setCategoryTitle('스토리');
  }, [categoryList]);

  const getCategorys = (categoryList) => {
    return categoryList.map((category) => {
      return (
        <Menu.Item
          key={category.id}
          icon={<FcShop style={{ fontSize: theme.fontSizeIcon }} />}
        >
          <Link to={category.url}> {category.name}</Link>
        </Menu.Item>
      );
    });
  };

  return (
    isCategory && (
      <Affix offsetTop={0}>
        <SiderAntd trigger={null} collapsible collapsed={collapsed}>
          <CategoryTitle>{categoryTitle}</CategoryTitle>
          <MenuAntd mode="inline">{getCategorys(categoryList)}</MenuAntd>
        </SiderAntd>
      </Affix>
    )
  );
}

export default Category;
