INSERT INTO public.contact (id, first_name, last_name, personal_code, phone_number, email) VALUES (DEFAULT, 'Mai', 'Legaalne', '40000000001', '5612345', 'mailegaalne@mail.com');
INSERT INTO public.contact (id, first_name, last_name, personal_code, phone_number, email) VALUES (DEFAULT, 'Siim', 'Massiiv', '40000000002', '56234567', 'siimmassiiv@mail.com');
INSERT INTO public.contact (id, first_name, last_name, personal_code, phone_number, email) VALUES (DEFAULT, 'James', 'Bond', '30000000003', '5312345', 'jamesbond@mail.com');
INSERT INTO public.contact (id, first_name, last_name, personal_code, phone_number, email) VALUES (DEFAULT, 'Jaak', 'Rauamaak', '39034590445', '5323448', 'jaak@mail.com');
INSERT INTO public.contact (id, first_name, last_name, personal_code, phone_number, email) VALUES (DEFAULT, 'Juhan', 'Parts', '354690646', '53288322', 'juhan@mail.com');
INSERT INTO public.contact (id, first_name, last_name, personal_code, phone_number, email) VALUES (DEFAULT, 'Mihkel', 'Raud', '30000000004', '5323429', 'mihkel@mail.com');
INSERT INTO public.contact (id, first_name, last_name, personal_code, phone_number, email) VALUES (DEFAULT, 'Jaan', 'Lill', '30000000004', '56792323', 'Jaan@mail.com');

INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Mustamäe');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Lasnamäe');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Haabersti');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Nõmme');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Põhja-Tallinn');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Kesklinn');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Kristiine');
INSERT INTO public.district (id, name) VALUES (DEFAULT, 'Pirita');

INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'Helme 10b,  Tallinn', 59.437860, 24.702200, 5);
INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'J.Sütiste tee 10, Tallinn', 59.399090, 24.696720, 1);
INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'Vikerlase 16 Tallinn', null, null, 2);
INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'Vabaduse pst 15, Tallinn', null, null, 4);
INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'Talli 5-19, Tallinn', null, null, 7);
INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'Kase 56, Tallinn', null, null, 8);
INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'Õismäe tee 45, Tallinn', null, null, 3);
INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'Pärnu mnt 56-67, Tallinn', null, null, 4);
INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'Manufaktuuri 20-249', null, null, 5);
INSERT INTO public.location (id, address, latitude, longitude, district_id) VALUES (DEFAULT, 'Punane 16, Tallinn', null, null, 2);



INSERT INTO public.role (id, name) VALUES (DEFAULT, 'sender');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'courier');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');

INSERT INTO public."user" (id, user_name, password, contact_id, is_active) VALUES (DEFAULT, 'mailegaalne', '1234', 1, TRUE);
INSERT INTO public."user" (id, user_name, password, contact_id, is_active) VALUES (DEFAULT, 'siimmassiiv', '1234', 2, TRUE);
INSERT INTO public."user" (id, user_name, password, contact_id, is_active) VALUES (DEFAULT, 'jamesbond', '1234', 3, TRUE);
INSERT INTO public."user" (id, user_name, password, contact_id, is_active) VALUES (DEFAULT, 'jaakrauamaak', '1234', 4, TRUE);
INSERT INTO public."user" (id, user_name, password, contact_id, is_active) VALUES (DEFAULT, 'juhan', '1234', 5, TRUE);
INSERT INTO public."user" (id, user_name, password, contact_id, is_active) VALUES (DEFAULT, 'mihkelr', '1234', 6, TRUE);
INSERT INTO public."user" (id, user_name, password, contact_id, is_active) VALUES (DEFAULT, 'lillejaan', '1234', 7, TRUE);

INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 1, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 2, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 2, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 2, 3);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 3, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 4, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 4, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 5, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 6, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 7, 2);


INSERT INTO public.shipment_price (id, dimensions, weight, price, type) VALUES (DEFAULT, '5x35x45cm', 5, 5, 'XS');
INSERT INTO public.shipment_price (id, dimensions, weight, price, type) VALUES (DEFAULT, '12x35x45cm', 35, 7, 'S');
INSERT INTO public.shipment_price (id, dimensions, weight, price, type) VALUES (DEFAULT, '20x35x45cm', 35, 9, 'M');
INSERT INTO public.shipment_price (id, dimensions, weight, price, type) VALUES (DEFAULT, '34x36x45cm', 35, 10, 'L');
INSERT INTO public.shipment_price (id, dimensions, weight, price, type) VALUES (DEFAULT, '60x36x60cm', 35, 13, 'XL');

INSERT INTO public.shipment (id, amount, description, shipment_price_id) VALUES (DEFAULT, 1, 'karp', 1);
INSERT INTO public.shipment (id, amount, description, shipment_price_id) VALUES (DEFAULT, 3, 'vaibad', 5);
INSERT INTO public.shipment (id, amount, description, shipment_price_id) VALUES (DEFAULT, 6, 'mobiiltelefon', 1);
INSERT INTO public.shipment (id, amount, description, shipment_price_id) VALUES (DEFAULT, 2, 'toolid', 5);
INSERT INTO public.shipment (id, amount, description, shipment_price_id) VALUES (DEFAULT, 1, 'karp', 4);

INSERT INTO public."order" (id, sender_user_id, receiver_name, receiver_phone_number, courier_user_id, delivery_date, from_hour, to_hour, comment, status, shipment_id) VALUES (DEFAULT, 1, 'Kristi',  '57123434', null, '2022-09-23', 14, 18, 'kiire', 'N', 1);
INSERT INTO public."order" (id, sender_user_id, receiver_name, receiver_phone_number, courier_user_id, delivery_date, from_hour, to_hour, comment, status, shipment_id) VALUES (DEFAULT, 1, 'Mihkel',  '5679993', null, '2022-09-23', 12, 13, 'kiire', 'N', 2);
INSERT INTO public."order" (id, sender_user_id, receiver_name, receiver_phone_number, courier_user_id, delivery_date, from_hour, to_hour, comment, status, shipment_id) VALUES (DEFAULT, 5, 'Juhan', '56890000', null, '2022-09-23', 10, 17, null, 'N', 3);
INSERT INTO public."order" (id, sender_user_id, receiver_name, receiver_phone_number, courier_user_id, delivery_date, from_hour, to_hour, comment, status, shipment_id) VALUES (DEFAULT, 6, 'Mihkel', '56768886', null, '2022-09-23', 13, 17, 'ei ole kiire', 'N', 4);
INSERT INTO public."order" (id, sender_user_id, receiver_name, receiver_phone_number, courier_user_id, delivery_date, from_hour, to_hour, comment, status, shipment_id) VALUES (DEFAULT, 1, 'Taavi', '5679344', null, '2022-09-23', 15, 16, 'õrn kaup', 'N', 5);

INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 1, 1, 'P');
INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 1, 3, 'D');
INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 2, 4, 'P');
INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 2, 2, 'D');
INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 3, 8, 'P');
INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 3, 10, 'D');
INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 4, 5, 'P');
INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 4, 8, 'D');
INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 5, 6, 'P');
INSERT INTO public.pickup_dropoff (id, order_id, location_id, type) VALUES (DEFAULT, 5, 7, 'D');



INSERT INTO public.image (id, base64)
VALUES (DEFAULT,
        '/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxITEhUSExMWFhUXFxoYGBcXGR4bGhgXGBsaFxgYHh4fICggGBolHRgXITEhJSkrLi4uGB8zODMtNygtLisBCgoKDg0OGxAQGy8lICUvLS0tLS01LS8tLS0tLS0tLS0tLS0tLy0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIAMIBAwMBIgACEQEDEQH/xAAbAAACAwEBAQAAAAAAAAAAAAAEBQIDBgABB//EAD4QAAIBAwMCAwcCAwYGAgMAAAECEQADIQQSMQVBIlFhBhMycYGRobHBQtHwBxQjUnLhFTNTYoLxorIWF5L/xAAYAQADAQEAAAAAAAAAAAAAAAABAgMABP/EACgRAAICAgICAgMBAAIDAAAAAAABAhEDIRIxIkFRYRNCgTIEkXGh8P/aAAwDAQACEQMRAD8A+r9J6fYuaeyz2bbE2kksinhR5j50N1r2W0Zs3SNPbVtjEFRtggEg4p/p7KoqoohVAAHkBgVX1CPdOCQJVhJ9QRQatGezI9E9i9Dd01m4bR3MilmDsJMZ7xzNX3v7OdE3/VHyf+YNR6N7T6XTaW0l65DqpGwAlsExwMYjmhtT/aVZyLVl2P8A3kIPxuNIlGtoyVnl3+zHTH4blwfMKf2FfOuv9E/u2pNqZAJAPEjkY863t32i11+0XtslmcAC2SwzzuJIIgdgDJHlSex0pt/vL7NccjJYmSe/NRyxjWtD/glIRezvs8+rvNbR1QhN3imDBA7fOtBc/s41Y4a0f/I/utHLttC5cEpCtJtDa+0eIjcCD2pKfa+3yNbrE+cN+pNJBRa6C8HHs9veweuXi2G+Tr+5FLLPRtYd+y1cOxijbQTDDkYrQ6L22VVE6+40DJe0sn1MCKK6J7Q73uf3bUoxZveOpSDubBbImMdsVuEPs34fgx72tSvKOI5lT+4oXUa1l+JV+qivqA9pNRbbbde1xIhSDH6GkvtXrxqwiF7A2ksJw0lWTueIY1mkumbhNGHTX8AqBPkSP0NELrV77h9Qf1rS+zuns2C7XLdvUAgDaSvhzyJmnTnprjx6Mr/oP58LCmim1/o3mjAHVr/m+6/yNeHUr5r9yP1FaTqPSenvdQoLtu0A2/u0/wAMSTieabW/7NNNdRblq/dCsAV3KOD6YNFKb+Dc5LswpYdvwQf3qpyO4P2NX+2XsqdFdVPee8VlLAxBxMiJPpmaP039m+ua2txGtEOoYAOQYYSBwBOaycm6oKy/QlIHYj71UyUz1fsl1K2yobTMWnbDK07RJ84x50v1nTNZaBL6a4I7m2wH3EU3JrtB/IvgFX/mD/Sf1FMrYxQfRenm8ousxUywAHkDHeTyKg73FwGH1FFtDx3tDIW68Kik17V3Qm4upzAUGCYme+Ig8+VAtrlPJg+v7ZzStsKr5H93VWx/EPpmgr3VEHAJ/FABlPf6cVUyfOhyY/FFt/qzdlA/NAX9fdP8RHyEVayiqGWjYHFAl5yeZPzM0GLRYyMCKPupUdFb8I+VOmIyhdGe5q3+60dtrwpQs1C86cV1GlK6jYOJveo/2p65/hK2x5Iufuc0mv8AX9RqYN26zHMf0ImlurSxwL2f9Ij8mas6Vr9PbBDLvcEwfEcEA8AR3rNtrRkoJ7CrStMSc9hkmjemaRhfQwQMyWMRII4Oe9Qs9Qa5KpZIHBkbBnt4mz8gKlZtXgQRbQHtufAjPAgCppTrZVyh6RvrXUbVlFVnE588rivNX1i26gyAA0E5AAIxOPMR86z3TG1jTs9wYgnepPPEGD5U90HvIRryWwQfEFQc5XuMjPyqLiktyKRk3+p17ULctuqkNKMBEnkH/trBD2V1ZGVM+QH4kV9TF+1wLaifK2tJD7U6YATZufa1PpMXJpISf6seVfsjD9I6BqBqEFy02zxCWU7eCQSY8wOfOttZ6cVCkgY4x+KEb2g0bOWnUqWjA2QI8lDGJ/nTDTaOxqDuD6gBeBclF8ieRuP86afKQsGo9FT6MlwZWOy8Y4/r6VmfaPp1wXQ0ArsGR4sy2MZrYf8ADrdtp3sQfWePmxjngV5q+qWLZXwsZn4bZbiOYbHIj60IOpd7DPa+jC9NKm4q7gCTEbYkntJP7VsrNlrYkECfITIj5Y71afaHTYlWX/UrLM/6nqTa6xcjYSI8oM/cnj96bJbetCQaS+RZrrd1nDBGuKAMqpGeSDA7E/allz2v19zfaF1rfuruxbaQrR4ozg9u5NaK/oLb+J3uz293de1iBMi2wDHvJrE9Y6aBqnTT7mLBXKtvduMtvMlstmf8wp4zpfZuEZvaCbXU72oG68z3SJALkEgDmMeH5UXovb3WoFS1eubVAULcS2YAGBIWeKX2LGotna+xczDSGIIw3Gc4z5H6xsezvu296PdHnwhxJkep5pYzqwzxR1SNRb9vdaXtu6WmKho7TugdiO1N/wD9mkLF3TqCfD/zIEmR3Bz6VirdhmAIst9GWZ+rUN1PRe/GwB1M7pC7uAe0+tNHJP2Tlhx+h10vrGlS3tKtO5jK7SIZiR39aRbd0kceuIHP2iqrKGwACGJxDbYzjtznt8qn1DXB7NxdyB+26A2QRwcsM8Zoxkm6MsfFaNN1O37PvZkIPe+6I3IXH+IQM5aDkHtSToPs7onsn+8f3gXA0A2TbgLC87yDumfpFJdJqboQJ7y0VHB920/hcx2FHWL8wm8b5JlbbLI9ZETj6008lbSsSOBN+TA9X0PQl2Uau8gBIX3lhX4gGSlyQZngcAUp0nRna6ba6i1bUFouXGdLZUcGIJUnyjvmm3VtIxNyFMtuiPWY86VjprL3+VZTXwZ4F6Zdf6Jq1Yqj2L+0BibV60wIM4EspJ8JkASJHmKE09m/cDFdNdYIYYojMFOeSoIXg8+VVXLLztCE+ZyPTvj1rUexHW7+ge4bahveQGVicgAgceRam0xXGa6Zkr13gFSGaAoI5J4/apIr2oW4hHriDFa/2p/tDOps2bNzS21Fp7bghjJFvgcYBrOdQ6zbvEObRVFjcoaZBPbA7CjXpAV+yn++r2BP2oe7rz2UfU1rfYjpfRtZ/dtNc98NU5cOVLgMQGZYIlRCgdhxV3Q/7N7WotXX9/dVl1b2FAgj3asBJxO6Ca3ET8vyYM6656faurRdT9hLlu69sX5CmJKZ4+ddW4h/KhnqukhVDe8aT5QI889qq6WoS+VPiG5cE8zA/ah7Vpzg3GI4+NvtxVvR711Hb3YXhWO4zmWGDtPlUpRk/Z1RnFejV+4t/wDSA/r5VTqNNp5mFxnK/au0vV9STDuEXuQAY+mwUws6wsARqi24YhOfOPFmorFL2yzzxXSGns1pGh4U529ueafXNGWWNsZU+X8Qms30v+8qx92xbgZAA8/+sJ4NNW1l0E++uFDjCCB/93/Wk/Ak7sH529JB3/DWP8J+wrFr7K3SpLaRwZIhgDgYBBnvE/Wthc6mhEbmjvGD9w3FLB7aW18AtX2C43EKZgx/mk8VoqFUguWRO6M3ovYy+NUt3+7lVH+gAeArx2z5VureluKqj3ZJkk5GJjzNILPtbZNyAlwMx+EiMwB5Y7d+9OtHq1uTvlNscnmZnj5fmnkl7EUmR1PT7jsJQgZM4OcYifnSnrfsu9xIFrd4XEyilC0CQS3OO1GXdYLdwhLciPinnicEHjGaA9oOvtZti4bQYAsSCdpUKpYsMZOKWLgnpbGfOvoz2m9gHR7VzIa26HxOhnbBMdxn1rV6jp7FVGTnMuPKJ5+VI/8A8pvlhGlgzEm4MTjsSfsKZdN6s94k3F+EY2ktnuMxRlkT7ZowktpEbWn2H3bEqx8QgbgRgHIwPqe9B67SIHDn4gsA+Un547U3bUSeGwAMjPPp2/nQNzU7WbfbDjkfDxAxkH1P1pfBrv8Aobmn0APdBAIiI7mOKzvStCC5DXdwNvcNkrDbgO5PYnFO9dqlyQsAnHnlhHA/ahBq0nxKMg8gxiM+hp4ONOmJLna0TvKltdo8WCZbxHOefSlHUL1xVDAkCeSY5E+VP9G1llksgycFCe34z50l13W7aFQbSywMYOYie/mR96KSb7DyaT8QvQW9y7nJbAJHA7Hmq9ddYq2yfhPhmTMGK8TWIwEoqg/6+Po3l5VDqCgIzWtpXAMFwDJAghjB57+dGl8g38GW/uepj/kXD5APcH71pdN71ECbSAB/kn55Ik/Mmaz9zXw3/KtHtBt/p4p/Navp9q0tvetm2rlMlRGIBPniYNNketv/AKFx1ekZwWQFBPvCZ5DvugHgZqFzTsR8V0eMASxMTM80Xf1quyswBM7QOwGfXPy5qepUhAxgAtECY4Jnn0oqX2Zrf+Rfq7Z7XbnlnYfztofSW2OCdxJIzCxEGZ78/ir94JMBBmAVJz9JxUdI53yVLEdgYA9fEZz6UXO9exeNboA6uoV53ifh2gExtEUBqb/vADuAAEQAR+/NNdfaBYscszNH/ae45il96wqnP0/qapF6FklfZov7JL1mx1Kzdv3QioLhBIkbjbZcntgnOfLvNfQPZX2r0Wmtst67BbVXrsBWbwtO04BzMYr49pLD3bqpaMXDIXPkCTmfKa2eh6rZ0qCzqun2bzqSfe3feeOeMG3wKzbbIShG/Y+X2y6eSxe4QTcuH4G+He2z/wCO2urL9P8AanQWkFt9BpbzAsS7bwTuYsBGwwFBCj0UV5R2I8cb6f8A6DRolAJlAewJH5zVFlv8dYVRiTtIMwymTHbxH715d0V4CQft/ImKnYsXC6w8NB5Ve8fPyrnjjjVWd8sk7to0FnWWXO1mB+QB/Y1Qpt/9NAY8h6T/AAxxOfWglsX5MhI9bRz9VOKKsMI+GyT9T+rTQhgUfdjT/wCQ5frRpfZ7LtIMFcE8HiDTzU6eVIC5jsJrM9O6trgQtuxZuKBCr71kwB/oMR86e6LUaxhN/TpaiYCXd0gjkk7TjyAqMv8Ai7uwr/kX6GR0bQTtx/P6Vi7/ALP65rtwrZ2qXbb4lIK7jB5BGIxFba7q7Z/hUxxIBj5ZMUob2iZCyooADNlnUT4iMYJiQRx2FFKCDymzO6b2U1vvUdwoAYE/4pGBz4R4SYrUaLpbIDJBJzzSS77ZagXVti1vDFQHS4pUbjGfAhEek1ola6STdeAMAozEz+Mc02SF1YsZvdFOp6cpK72IGfgMEnkDjjBoPqXs8l8BFZ1OYnxggjIIYAR/v50TrGUxLkxJ8XYxAI8sFhjzrNe0jFNm12Uk8ggzxiGDDv5UmNxUuKGkpONsaW/ZIggnUkZkyqfz9Kut6JLBIF1DunIKkASInxYJrIWXUvbVrt1ZdRhwJlhIMJ3GMRW1sdHs2yXVnLcEM5ZYPoceWapkjH9hISl1Fgmp6kquAr2SpBmQWMjiIYADmeaCva1L25Ua2WWNyicbhIwJIBHE0d1LTloFtFmQD8K857x5Umv6i8jsq7BBgkBTkCDmDP3qfJdVoqoPu9lmqTwFCthW2gzuctjMxticUru6I/8AUtkzEQR9Z257U16hoA1t38J8BMbhJ8MwFJ5PEVn7du3uJFsWz4RACr5ycE5qifg3xJ8fNLl/RlptPC4CmDzsc0L1XRW3NvabVuNwm2m05gkeImeO0fWibGqu79kkWhj0MjuBzkmlvVdA7MuzaQJ5UkZ2xEEfKZ/WhjlvSobJCu5WXL044hpAgAx6c81T1G0wVlVkBj/IJJx3JIH2qxEubgAvhIgDjjM5wKr1GnbxF9oE+Ee8AJwOYBMzPHlWjyvoEuKW2KNzg7S1ufnYH6gGnVhmtlluXLTgAYUncB8Pw7FEfWgG0NtiCUBbgf4+fkNyfiabJ0shTvR7QnJYqZ78iPtVcnLVUJj4btsVap7IIJGT2AxwSPx3oJ+oD4POcdsAyZPeJo7XaK3OLggHB7nEUI2ltqfiJbMCDwcE8Uq5e6G8K9lVhISVAAgkCeAJ7QfLzqvTNuaGUTAyBP3r06pB4VJbkGRHzHr3qNnX2d3jfYe30jGMU7t/Yqpb6ANcdpO4jkt8JxJ75HlQbnecsDPkvEf+R9OaK1mn8XrEnOIM89qCuBRgH5xBj7VSPRN1fbIWtNLbFKzGCcAAfSm79U1NtNvvAyzBFzxqfpmB9qh7Pe4F2570Kyi0xAcDL+HbAPeJoGwlsqJW5MZnbE9+81m17F4tsfWNK7Krf3K0dwBlWYAzmQJxXVoB1G3aC2pB2KqzI7KK6p/wpwYuN0ydxYAkxAwB5ete9L01tdQtwMBLEN/5AmYHrGa1J6MhWdoXHO6OfrFINTo4Kq7228SSBDGdwz8ommhNPVCSi0+zT2tWjMRtOD8RIAPyABNKdeupBItXAVLEhSikKCZieTFM29lLg8SMpBAI2kqfzg/ehTe92Sr3CpBI8Q7jByIpIxxpjSlOhr0INFrcPFtyQIExB/WtLb0rH+H9TSLofUbm9Nmx+doBiQckTny/FaQdU1UndZtIOxN3dPnPEfmpzxJu7KRytKqFQ6ZqHEi2RuzDYKz2MjB+U0l1HsJfe4zsYkz/AM0gZzwP65pv/ihifeXD2y5I/NA3Oq6pWZUuWra7iT/iHeT3JULjz+KjBpPQs+bWyvSexrC6q+9yIbwlmEDP6gj6GtZe6fiGubZJPEfqRjNYa31e+bihriZIUkI+4qTkbix/lT7TaRFJfxOWxDHHcgyACeIpsjpXIXGm/wDIyt6OwreO+rGOGZSPtnNUdStaRtsj3kHhQwjBzhRPlHrVF7xLARQTxtBnkeZM/wDukvtL0xntKDj/ABByAw+FsQRFShJWlFFZQdXJh1y/o0IC27QJ4Dssk+gLST9KJsay45hLKsBk5CgfU4P0rIaTptxIYqmwGS22IHfjFNemsgMKGac+FCZPpijlk4ySqzY4KUW7Hd5YIuMqggFRtbjgkSpHpj0FBX9QCSze6AHdgxaAPnEVZuuH/DFi6BMyywO/mZj6UFrdAWcoGMjDBACRic+WCOayeT0gqOPpsS67qRS221VwREgH+IDkxJzQeh1z3ix3RtgDwFD4pnloPHOae9QSwLe17dpVwCxwcEZk8GRQHTzoxu90wORPuyDnPOYH/univF2xJSXJUi99KAPFcbAnJjtNZzq3vFdBDwQZyc5GZPl+9aXVaeF37FiQZe6CSJ8lyDSLq3VQrBfdpkHLEn8HP4oQjUtv+GlK46X9I3FtoC4IJmNrHcI4nxfTihrrFpZdsc4UmfMeEYznngU3saIL4mYCMeBVB8u4P3ml2qt3SDsNwrMqGMDJkzjaTPpSVHl3f0WuXDpL7BUQyDv2wR/FeX9TFHublxSqOXkjG8nz7E1Hpf8AePeoLiPszLTgYMTA84+9FdbS6FXaVXJmMEgR3n1qmRK1ZLG2k6E9vxuS63DtBA2jAyJ5EfwiqtUFJBUOCF2jeVgD5Az3qso5JMkD/KpMT558665bePDjsckQDP8AKtxWtWbk1e6A1tQCTB5ImT84jtUrNpZmckTG3AA7TJ2/XPpTDeiJ8AXwxgntjj6edC6G9bUt48kE7YOSZjNOv/AreuxRft7BtZskdvEYOflQTMqkgBv0phrEBMN8QA444Hyj80DcABKgzHJzz5dqqmTqyu25OVBHriZqTX7np9RXWWPZSR6R2+1cz+hH0P8AvSvvoaOkUG9c/wAorqmWPmPz/Kupv4C/tn0LSLe2hgN4Plk+XHJqw6y1DbgCwUnbJBBGQYwRV/TuoqihDbUMJzmOfKcVZqdOLzgkL5YA7iKWDn7BJR9Gs0nXrW0CHkADLx+1D9TvC6pAtWxOZgkz5zOT9KA6V0xblm2QHRioJjxZ+VdqNPd0+SrFcZHh+4NJGcW+hpY5JdhfTtOQEG0wuJjBHEfpTtdPMQkxxAmKUdL6uQVCuRJHhZYn0rTHrF6fgtqvqTP3/wBqlkwpu7KQyySqirT6J3nem0epmfXtFLdZ7M/4jMWCgkHn0A4j0pjd6xd+FTA9AO+ZrLda69q1uuiuu3w5KlmkqCclojP+WmxpcvF7Fm5NeS0O9P0XTiDvZo7iBDAjseaKYrxucDuYHbjsZmTWEbX6tubxYeQAX8oAfvTjQ6m7bJcMwYiCTkkYPf1o5rX+tmxJu+Oh9f09swYuN/qxSzqOutWNjGxCl9vAYklWMEYIGJmew86jp9e5f/EckRyzGB+cVV1m0l1VVXkhwfChMmGEAnvmpQbclUdDzXFO5bK73tAt3Yq2wo3DhgvOOPFPMx6U20rMm52dgDj/AA/iwSMk4AxSaz7POIb3dzBEFoTPbGTTXU29QyQNgPM7Se/BMjzPlx9KvNU9EY0+wPWXyzYL8fxHcT9YEUt1IIZibShiBLbBvOBGSJ4imQ6fdXL6hlnkIAs8zxOBNdc04JMvuGI53YAMsfU+Q78VzShLtyOiMorqIo6noC1rFxVcwQoMv8ogjjmhtB0y4khzunIlQMZH8Ig/arusdTu2wDbMEmDtmYgntQWlFx1LuHMn+P74EDw/OnjSxXFaBK3l29jW9bthZd7YBAIG4A5yMDP8qRa4aTdLEExiJPn2bmm13Vkr7slVHngcecCTSvUaEs4ZGaAADEgEgk8nHcdq2JrlpV9myqSjt/wMS4XBAQkDszBc/wDyNLNfddAZUR5ZaPQBsR9KaDVqCVlQSCTBLQRGDtkyZ49KWdV1RK5DKob4kQKZ4HxHce+MdqaCdiyaoH6d1S2Wh7I+gVPyBTDXa22sMquFjIY7vnyaj0oNdU7LzDaRPvADzP8A2nyPevNYuWR/dk8boiO+M8/Sjkvlp19Gx8eO1b+Qe011wShQJOBgMPvjz4oO+lzI5nBiDj7VbptRI2wwWeQAeO88ChXLHENzJEkfz/StdyrZqpXolrb6kANjM4P44/FLDbXdIuhTHDqV7djxR2tVYGGBHHHPAwASeap01yzG13G4E/EDP5701auhb3Vi6/A8JInvtO6fqcD7GgnEEwJHJLf1Ao+7ZUGOWwTGYnjmhLl0zgRHPnM5zVkxGv8A59FazkkTPy/eoO0dj9Af2qSOZY9+O3rXj3D6H6R+9ZoCbKGnzP5rqkbp8h9/9q6moFn1fpSWn3bnQjsScx9K91tu2kG2+7iQBEesmJ+1LNR08lptyhHEiP6FSt32B23Vz5j9flUMfF9Mpk5ex50rqF63a2FjtDMsccMR9eBRZdX+Ic+Yqro7o+9SygBpzPcBjj5mjNRatr8BJPl/D/OmUmnTQjiqtMp/uD4a2rMFIOMkZ8vKjyCZE8dh2+1UaK80Ssgqexp9p9TsHx2LZ77V3MT681LLijJ3dFceWUVVWDIkAeC4zceEeXGT3iKpbpIe4xK+KBO4zzxxjtT/AEmoNxN5g5OT5fLgVn/aTVXveBbd11QoDFs7cy0mVzxHejDUvEWdtbDbHRwsl22L5wBnyloqVzS6UlQt0vJJy26YBGIwIMHntFZFumEncw3H/M/ib7mTRGl04turkrt27YB4MngfKB9KfK5xV9i44wk+6NI9i0i4XcRjkd/qcUr6n1BraBkW2GDCCwLbcHIyAD6+tSVixBK3GX0EcevapXdK1yAtoICR4mYtHrFRi5uSvRWSglrYku9S1jn/AJxieFUL+VE/mtfqPdyzKBK8NPaaUHTWLZi5qR6qpAPrzJ/FT0t3SFoQTEybhYz9D/Kq5HH0Sgn8FPVb1sldzZzESx7Tx+5FV7QAxR18I3Fc7oicqJj70bq9QJAXaYwMbR+3l+KD/wCIMsqZIOIEQJxJ9BMn5Vz8oXR0cZuP0KNf1RFAN1G2zChFiTHeBI+tR6fqrdyHS0qqTH+IWY47wCB96s6zoFvKqgnDTwQMjsZHp+ar0ekS2I97GeI3STGRH257GqW+GuxKjy30e3bZgKHjjAVV4zPhEk4Hes9rdLc/vKiSUBRiD3jnnnHnT7XttAJtuDOdxGcZ8Ky0fOkz9RYXgoRVWRJ7xAOJ4+9aHK/JmlTWkPNQ5dAFUjOYEACPMc0g6rrFiGxLZ4ZSQD2Ax9TTXUOpX3jFmGcOZiI4Hf6zSPqzqVXwlgWJx4ftPP0rQStUGTajsu6bZYqTaKsCc7WIMjt5d6uvaUsSxndOR5ACJJpdpr6qoUe8QTPiUnmBypPlRl5JtkqWbc0k7W4APE8zNZwuTdf0yl4pXX0DtqkUGFbgxuBE44gZH1oO7ecqvKlhuiIxJHpPE0yWVTDH025AA5zS06obgArTyZzjgD9DVP27E1x6/oLcQgfEcTECfi59a80mqQKAX7mQVMcyeREmr9fbyDnC+WeTNUaO2oBPvIkHGzEwe4x5Vq10ZPfYK6eLwiWMT9aV6iWJAOJ+kz/XNG3lUQMnj0/3NAalQckhV7D+v2q0ST0e6fTFgfFBH/uuuaRx3Bry3jA+/nUyTVEiT7BTYb+jXVeWNdR2CkfRdWrhgLlzczZ8gYx2rjpVbEAf150RqrqEoz2rigfxNE57bSST+K7Vau2B4EJ+Z/25rki5J7R1PjWmWdF0pa5cVWhlCtB7zK89vhFMxfZDtuCCImfX14NBdM1jBlZRKshEHDDawxI5+I0y1Vz3oiAPoJFZOal9Aai19hvT9QhkbuasSzZkglnbyUH9cfrSbRaAliCc9jwfl5U5fSXdg33W2QMKAI+ZH60mVRb2PiclpDrpwvC2VS3AkgMzAbRiBt74qHUdJdLEu1sAJ8QMAGcKZ+8170y+QhVWkKYH1APb1mlHtRofetbJgwCM8g44oQyJy4o08bS5MsvNoVhnue8jsjFpP/iDRGn6zpWIFuzt7hiAG4yOSYz50t03s+55DEeogfc0YnQEVg2+G8llp9P6NPktLxexMfFvyQdf6l4fDgz88fb96T9WZ3Ta0kHkGYP7U9XQqviAJggyx2gQcnH6TVHUep2VQtLMwjKgHvEDsJ4571BRldyZVyjVRRmrXRGIwhVft/KmWi6RtYHcJ8vpHPHcfaqNd7T3XBW3aVSf82SfoI/+1HKxZd2QVj5NIjI7jJ+1WzbXkieJtdM91ekTA97HMgZnj5R3pV1TqJtfCcGBtKjPaZgN5UVqNRtjcwWZEkcd8ADPFCXEVjMs5EZK7cciJ8j51JW14qkV0ncnbEPUbl1gNpcSe0yR/XrRvSLdy2gkFVSSceZJJP0nmreq9Ya1t22wSwI5kiIzMZOfLtUumalryMHbJaFX4cEAzBmTM5p0vDYrl52inUqGGWAHnIpbdu6ZD4iz3JAIRcDyz8o4NE3ySSrAc52ieD58mg30alzc8IEwDcIBYgAQAMmtipu6NktKmya6p5Jt21UcSSWb8jH3NKOpy21IkgthRMcdl4+vlTq2UkwZAmd3hEziIye+Plx3X9Xtq4CrtWCWwAPSeJn1NGL8lbNJeLpEuisttdrHJadnpA5H3rzW3L7HashSxA4EKOOMgRRGhAFpEc7iSZLHdGTAAPpGKCv3rhIUggHgbYwPIeVBu5vsyVQXRTcurbGwRHeD+IHPbmg7monC4x3jHpR2puDbJtoMxO3P4xPzmgLIXdP3PB3Hn+vWq+9iega9aYkbiTjvjA8/KvbVshAFUgAHKjcuZMz2qWuC7vCTJyQPQQP3M14qKyEywYDaeCCSPoR9a3HxujcvKrF2CSoPHLUHfIGSJby8v5Ue1kklR4V9Ikn9vp968XSAVeMSEpr0CWgTkj0A9KmyelEm1UGSqUJYKVr2r9tdW2az6J1dZtkSAZETiTS9bFxQz7di9gxWSPlMkfmidRoEdDCZ2zIncDHn/vSa09y0FN2Wtt8Nwdu0N5GuDC43pnZli0to0fRNegdFIw24EfNZgefwim2ovoDJUhe3cj5R2rMDTqQGB/iXaR2ltp/WmIuMp2XR8m8/51RxXLT/AITt1sf6Qj4gdy+Y7fOtHptOHQMXG2PKfT0rEadWRgyHBOY4PbI861Og6haNpWK7jJ+XODHrzU5uK/0PBS/UY27dtJ2DfOSdwAniMcfeqdV1ZLcE7RmAEWSTHn2+c9qDlrxhFj0XyzmrNX0JmUbo5mJz5fSki7euhpqlvsBve0ct4bbHPxOwEesCZ+81Vc6pqCw4XvhcEduckfUfSjrfTkU5YA+SjcfLmj2s20GT9WOPr2p8lNUhMbae0CBrlxSCckeUCe30+c1Xe6IdhL3QT/lAO3GZJPb5CmNzUKMCI/r+uKV6/qF8qxVQOcnMftUtJ3Irt6Wjxemqvf5wIAq//DjwNPqMj9/2rM3dNduZd2nyJkf/AM8D7U56chRcyY88AfyFXndfJGKRfcRZz4iPMcUFrAZwrHA7GOYnyoi8bsAqVUk8ngD5kc/SgNZcuDm47kwpAJCgEwTHcx3qTWvIqrvQD1O2IDXCqxMAEE5/Hb51VoLibW2CY7tIHnx3/So6zRXGwokz8IzGPT+dWWdGbYO91XmRzmPTimTfHQGly2V3XWCFPbHznPzxSTUaR2u79swQQTniD+tOtTctiQoMjJLEDHER25pFqGutdGfArK20cMBBIPz4xSY75bexp1WloK3LBwGM525E+U8D6mlPUA6jcG2Et3aZ58P+UD+prS6rUKUB27BPeAPoe4+VJtRdYjxbSs8BBHfOZLH1/FUxqpIScrizrHUEKhblnxhJ3qRBIWd0Rjjzqq5eNxI2kSMPuJYCZhfL/epe504Acb0cZgDwt5jnHPBFVlWbJLD658ueaeMblpiyaUdohfdQIYlo7HMHt5evJoO+hZSFAT05J+Z7fQUyt6NYiMEz9atFiOKrCG9olKelTFFnQiSTy39RVx05o82K8ZKqkkqEbbdi17EcCqSnpTJkNUMtEAEbdUNbo5xQ7iiKwQj+orqu211EFGs0+suG0oFwgREAZjjk/rFVnWutv3RA2EETtBkHkH70HY6mFX4CT5DA+9H9M16XLbI4zJKiOJAxP+1cKUovyO2UoteIqttcsghJdInbyRGZFbD/AI7b1FqLaJxnuw9QT+opFbtbT3K9xyVBxI8x6VavSB7q3fsMEfYJEgK5jOPP+uapOm1a/pKF06/6D9PcIODBHnwfnWl6PqLCp/iLtIPwidsekdqyXTOprdIVhtuDt61tejWwu4NyPMds1PIl+yHi3+oZpepJPhXYomfDlvKDzUOp9dAQ7bYMERu9T9z+K81GnNwQk5bJ4gQf5D71w6bbAksSR2GTj8fmpJtvXQ9L32ZvUa3Xu0rCr/lUBAfWZ3fY016TpXGTEnLRJnEcmJom/fs2stC/6zn7VUNcl7wjeRzjwr9sT9qpLrSFV3sZ3LYnyqLamPhUepOJ/r0qKQABzgRnAHl512ycxUk1eh3dbE97q6KJVd3+gbR9zn8Go2+q3Lm0fACf4RgQePIT6VK304LCkgY+eBifyKKC20E+JojABMTxPYfmrSqtPYkX8rQuu3R43JMYkmW7gf0POhn1JGTZYoYAZzt3PyAFHI9Zplq2aPiVRjC+JufsKB6xpmARyxncBuaTP07j8VNKvtj3evRn+r9S1TkCyQiyQ3h7YwOPuahprOIJZm7Zk/8AqmJfMQXI4NwYHyXifnXl0Fp3E+LmMA42jA9AKpDHKcdiymoS0hfaQIS24sT8UDHnzxzFeG4zzEBT3GWPbnijrenH8fiHrg44z3qThZwI9O1Njw8HVaFyZue/YruaMtJLEk92M/ir/ciACJPmf5dhRvuprvc1bhG7okpuqsXjRjt/XeprYA7Uf7uoFKKil0BtvsDNqoG3RjCq2FMAGIqtlFFxVJWsAGZKHuJRjLVTqaYADcAoZ0o981Sy0QARWuokrXVjBGo0ncVXaBXim+yqblikpPsNtdF/T7wcgHDTRDdNa2CyiQWaROD4jx5NFK/cmZ/NO+la9iptNGWkeuAI9OJpJxroaL2LdRoBcG5ZDDg9wfI059m+salSbLW/esB4TIAicnce2Rjmu9znyb8H0NF9Hs/4oA5IIIPbvI8xipZJNR6srjSb+BkNRqWzdNvbzsSScZEsf2q3Um+6MB4AVPGO3nzRD2VCxujg+HPBBjy7RRF7UKBHhjy5+/b8mubylt6L2lpbMjpOgEtO5z8sn6sac6LRpZMiA3p4m8+2B+KF1ftMs7EDOfICBj55/FE9Gu3XgXbaqnl38xnk/ir8m9EnHjsYf3xYBg/XH9feqdrvy2JOBjvXjiW8CEweTx9zRGntALLGcnjiZznvmpqI3KjPX9FqLjEG6LaKxACwSVBxPzHrTvQ2VtW2UHmcnGSIoW71RFMACZ/hyefM8fSl17VljPHryfuaso2tIm38hB0UQfeHcCCCOAQQe+T+KG6jaaUYZbcNxaSSvcDyPcfKqbRdWB3bhOdxyPkfL0NF3X3CgsbTprQXk9p7BfdCPrNQYAfOiXEV6Lc81eKUVSJSbk7YIUmvRYo1bYHauK0QAgQVEpRRSq9lEAPtqDJV7JUCtYwMRVTijGSq2SsYEIqs0UwqllomBnB86qg0QwqtxRACuKHuUYy1TcMCsADr2pM1eUTWOamnpUFirFFKE4pVbWqJWKl7uaxi7Q6rd4H57N5+h9fWmugtb7gQGCMz3GKS+7HlTHo2rCXBu+HOfLEQanOOrQ8XsfarQ27dtmJZmGZJ4yJwOKuGkMDbAxJJ71R/xFbgItQYwScifl3q8OzggDaI7iftwBXM48uyylx6KE06L3A/05J+vFB6nqTAkIqrH8T+Jj6gDj6igHvuwiYERAwKHe2f4cVb8bfbJqaT6L9T111iVZxOWMY/8R2/Smen6xutgr8P+Y4WfnxSi1piOTNWf3bEQIHHp3OKDxfAfyfRnrRuC40SRuPyiTmnFtye0evb/ejLenC8x+lWpYngVRCNg1u38z8+PtV9u2auS1HPPrVlGgWVi0K9AqRFe0TFbCvNtWVGsArK15FWEVE0QlDiqgpohlqpj6VgFTCqSKKZaouUQA7g1UwokiqHrBKHqlhRDVS4ogBnqi7RF2hLpogKSgrqrL11EA5tGrlPFdXUjGRdaohOa6urBJVwrq6ihQzppjUAedvPrkVq+oGFaMY7V1dUp9jxMklW11dVBSVnmrmrq6lGIRmiVrq6sY9uft+5qFe11FGOPFRFe11AxwrwV1dRAQavHrq6iYiarrq6sAoNeNXV1FGKH5qlxzXV1YyKn4oe7XV1FmfRQ9AajiurqIAM11dXUBkf/9k=');

INSERT INTO public.order_image (id, order_id, image_id, type) VALUES (DEFAULT, 2, 1, 'D')
